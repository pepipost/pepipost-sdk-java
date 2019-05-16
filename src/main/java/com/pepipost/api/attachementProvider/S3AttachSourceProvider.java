package com.pepipost.api.attachementProvider;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.crypto.SecretKey;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3Encryption;
import com.amazonaws.services.s3.AmazonS3EncryptionClientBuilder;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.pepipost.api.exceptions.APIException;
import com.pepipost.api.models.EmailBodyAttachments;
import com.pepipost.api.models.EmailBodyAttachmentsBuilder;
import com.pepipost.api.models.FileObjects;
import com.pepipost.utils.PepiPostUtil;

/**
 * Implementation of AWS S3 as attachement source provider.
 * 
 * @author d.chaudhary
 *
 */
public class S3AttachSourceProvider implements AttachSourceProvider
{
	String						s3_region_name;
	long						max_attachment_size;													// mb
	HashMap< String, AmazonS3 >	s3ClientConnectionMapWithNoEnc	= new HashMap< String, AmazonS3 >( );
	AWSCredentials				credentials						= null;
	
	/**
	 * Constructor - initializ with a specific region name.
	 * 
	 * @param s3_region_name
	 * @throws APIException
	 */
	public S3AttachSourceProvider ( String s3_region_name, long max_attachment_size ) throws APIException
	{
		this.s3_region_name = s3_region_name;
		this.max_attachment_size = max_attachment_size;
		try
		{
			credentials = new ProfileCredentialsProvider( ).getCredentials( );
		}
		catch ( Exception e )
		{
			throw new APIException(
			        "AmazonClientException: " + "Cannot load the credentials from the credential profiles file. "
			                + "Please make sure that your credentials file is at the correct "
			                + "location (~/.aws/credentials), and is in valid format." + e.getMessage( ) );
		}
	}
	
	/**
	 * 
	 * @param encryptionType
	 * @param path_to_key
	 * @param s3_region_name
	 * @return
	 * @throws APIException
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	private AmazonS3 getS3ClientConnection ( String encryptionType, String path_to_key, String s3_region_name,
	        AWSCredentials credentials, String rsa_pub_keyName, String rsa_pvt_keyName, String aes_masterKeyName,
	        String kms_cmk_id ) throws APIException
	
	{
		try
		{
			if ( encryptionType == "RSA" )
			{
				KeyPair keyPair = PepiPostUtil.loadKeyPair( path_to_key, rsa_pub_keyName, rsa_pvt_keyName, "RSA" );
				EncryptionMaterials encryptionMaterials = new EncryptionMaterials( keyPair );
				return AmazonS3EncryptionClientBuilder.standard( ).withCredentials( new ProfileCredentialsProvider( ) )
				        .withEncryptionMaterials( new StaticEncryptionMaterialsProvider( encryptionMaterials ) )
				        .withRegion( this.s3_region_name ).build( );
				
			}
			else if ( encryptionType == "AES" )
			{
				SecretKey symKey = PepiPostUtil.loadSymmetricAESKey( path_to_key, aes_masterKeyName, "AES" );
				EncryptionMaterials encryptionMaterials = new EncryptionMaterials( symKey );
				return AmazonS3EncryptionClientBuilder.standard( ).withCredentials( new ProfileCredentialsProvider( ) )
				        .withEncryptionMaterials( new StaticEncryptionMaterialsProvider( encryptionMaterials ) )
				        .withRegion( this.s3_region_name ).build( );
				
			}
			else if ( encryptionType == "AWSKMS" )
			{
				KMSEncryptionMaterialsProvider materialProvider = new KMSEncryptionMaterialsProvider( kms_cmk_id );
				CryptoConfiguration cryptoConfig = new CryptoConfiguration( )
				        .withAwsKmsRegion( RegionUtils.getRegion( this.s3_region_name ) );
				return ( AmazonS3Encryption ) AmazonS3EncryptionClientBuilder.standard( )
				        .withCredentials( new ProfileCredentialsProvider( ) )
				        .withEncryptionMaterials( materialProvider ).withCryptoConfiguration( cryptoConfig )
				        .withRegion( this.s3_region_name ).build( );
				
			}
			else
			{
				AmazonS3 s3ClientConnection = s3ClientConnectionMapWithNoEnc.get( "GENERIC" );
				if ( null == s3ClientConnection )
					s3ClientConnectionMapWithNoEnc.put( "GENERIC",
					        AmazonS3ClientBuilder.standard( )
					                .withCredentials( new AWSStaticCredentialsProvider( credentials ) )
					                .withRegion( s3_region_name ).build( ) );
				
				return s3ClientConnectionMapWithNoEnc.get( "GENERIC" );
			}
		}
		catch ( InvalidKeyException e )
		{
			e.printStackTrace( );
			throw new APIException( "AmazonServiceException: " + e.getMessage( ) );
		}
		catch ( NoSuchAlgorithmException e )
		{
			e.printStackTrace( );
			throw new APIException( "AmazonServiceException: " + e.getMessage( ) );
		}
		catch ( InvalidKeySpecException e )
		{
			e.printStackTrace( );
			throw new APIException( "AmazonServiceException: " + e.getMessage( ) );
		}
		catch ( IOException e )
		{
			e.printStackTrace( );
			throw new APIException( "AmazonServiceException: " + e.getMessage( ) );
		}
	}
	
	/**
	 * @throws APIException
	 */
	public List< EmailBodyAttachments > getFileObjects ( List< FileObjects > fileObjectsList ) throws APIException
	{
		List< EmailBodyAttachments > emailBodyAttachments = new ArrayList< EmailBodyAttachments >( );
		
		Iterator< FileObjects > fileObjItr = fileObjectsList.iterator( );
		long s3FileSize = 0;
		while ( fileObjItr.hasNext( ) )
		{
			FileObjects fileObjects = ( FileObjects ) fileObjItr.next( );
			String bucketName = fileObjects.getFolderName( );
			AmazonS3 s3Connection = null;
			s3Connection = this.getS3ClientConnection( fileObjects.getEncyrptionType( ), fileObjects.getPath_to_keys( ),
			        this.s3_region_name, credentials, fileObjects.getRsa_pub_keyName( ),
			        fileObjects.getRsa_pvt_keyName( ), fileObjects.getAes_master_keyName( ),
			        fileObjects.getKms_cmk_id( ) );
			
			List< String > filesList = fileObjects.getFileLists( );
			Iterator< String > filesItr = filesList.iterator( );
			while ( filesItr.hasNext( ) )
			{
				String fileName = filesItr.next( );
				System.out.println( "Downloading an object: " + bucketName + " : " + fileName );
				try
				{
					long fileSize = 0;
					S3Object object = s3Connection.getObject( new GetObjectRequest( bucketName, fileName ) );
					fileSize = object.getObjectMetadata( ).getContentLength( );
					s3FileSize = s3FileSize + fileSize;
					
					EmailBodyAttachmentsBuilder bodyAttachmentsBuilder = new EmailBodyAttachmentsBuilder( );
					bodyAttachmentsBuilder
					        .fileContent( PepiPostUtil.encodeInputStreamToBase64Binary( object.getObjectContent( ) ) );
					bodyAttachmentsBuilder.fileName( fileName );
					// bodyAttachmentsBuilder.fileSize( fileSize );
					emailBodyAttachments.add( bodyAttachmentsBuilder.build( ) );
				}
				catch ( AmazonServiceException ase )
				{
					System.out.println( "Caught an AmazonServiceException, which means your request made it "
					        + "to Amazon S3, but was rejected with an error response for some reason." );
					System.out.println( "Error Message:    " + ase.getMessage( ) );
					System.out.println( "HTTP Status Code: " + ase.getStatusCode( ) );
					System.out.println( "AWS Error Code:   " + ase.getErrorCode( ) );
					System.out.println( "Error Type:       " + ase.getErrorType( ) );
					System.out.println( "Request ID:       " + ase.getRequestId( ) );
					throw new APIException( "AmazonServiceException: " + ase.getMessage( ) );
				}
				catch ( AmazonClientException ace )
				{
					System.out.println( "Caught an AmazonClientException, which means the client encountered "
					        + "a serious internal problem while trying to communicate with S3, "
					        + "such as not being able to access the network." );
					System.out.println( "Error Message: " + ace.getMessage( ) );
					throw new APIException( "AmazonClientException: " + ace.getMessage( ) );
				}
				finally
				{
					if ( null != s3Connection && fileObjects.getEncyrptionType( ) != "NONE" )
						s3Connection.shutdown( );
				}
			}
		}
		long s3FileSizeInKB = s3FileSize / 1024;
		long s3FileSizeInMB = s3FileSizeInKB / 1024;
		System.out.println( "calculated total file Size: " + s3FileSizeInMB + "MB / " + s3FileSizeInKB + "KB." );
		checkMaxFileSizeExceeded( max_attachment_size, s3FileSizeInMB );
		return emailBodyAttachments;
	}
	
	/**
	 * 
	 */
	public String getAttachSourceProviderName ( )
	{
		return "Amazon_S3";
	}
	
	/**
	 * 
	 */
	public void checkMaxFileSizeExceeded ( long max_file_size, long current_file_size ) throws APIException
	{
		if ( current_file_size > max_file_size )
		{
			throw new APIException(
			        "Exceeded File Size Limit of " + max_file_size + ". Current Size: " + current_file_size + "MB." );
		}
		
	}
	
	public void closeS3ConnectionRem ( )
	{
		AmazonS3 amazonS3 = this.s3ClientConnectionMapWithNoEnc.get( "GENERIC" );
		if ( null != amazonS3 )
			amazonS3.shutdown( );
	}
}
