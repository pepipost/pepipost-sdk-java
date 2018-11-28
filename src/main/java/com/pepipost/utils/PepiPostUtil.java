package com.pepipost.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.amazonaws.util.IOUtils;

import software.amazon.ion.SymbolTable;

public class PepiPostUtil
{
	public static String encodeInputStreamToBase64Binary ( InputStream input )
	{
		String encodedfile = null;
		try
		{
			byte [ ] bytes = IOUtils.toByteArray( input );
			encodedfile = new String( Base64.getEncoder( ).encode( bytes ), "UTF-8" );
		}
		catch ( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
		
		return encodedfile;
	}
	
	public static byte [ ] toByteArray ( InputStream in ) throws IOException
	{
		
		ByteArrayOutputStream os = new ByteArrayOutputStream( );
		
		byte [ ] buffer = new byte [ 1024 ];
		int len;
		
		// read bytes from the input stream and store them in buffer
		while ( ( len = in.read( buffer ) ) != -1 )
		{
			// write bytes from the buffer into output stream
			os.write( buffer, 0, len );
		}
		
		return os.toByteArray( );
	}
	
	public static KeyPair loadKeyPair ( String dir, String publicKeyName, String privateKeyName, String algorithm )
	        throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
	{
		// Read the public key from the specified file.
		File publicKeyFile = new File( dir + File.separator + publicKeyName );
		FileInputStream publicKeyInputStream = new FileInputStream( publicKeyFile );
		byte [ ] encodedPublicKey = new byte [ ( int ) publicKeyFile.length( ) ];
		publicKeyInputStream.read( encodedPublicKey );
		publicKeyInputStream.close( );
		
		// Read the private key from the specified file.
		File privateKeyFile = new File( dir + File.separator + privateKeyName );
		FileInputStream privateKeyInputStream = new FileInputStream( privateKeyFile );
		byte [ ] encodedPrivateKey = new byte [ ( int ) privateKeyFile.length( ) ];
		privateKeyInputStream.read( encodedPrivateKey );
		privateKeyInputStream.close( );
		
		// Convert the keys into a key pair.
		KeyFactory keyFactory = KeyFactory.getInstance( algorithm );
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec( encodedPublicKey );
		PublicKey publicKey = keyFactory.generatePublic( publicKeySpec );
		
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec( encodedPrivateKey );
		PrivateKey privateKey = keyFactory.generatePrivate( privateKeySpec );
		
		return new KeyPair( publicKey, privateKey );
	}
	
	public static SecretKey loadSymmetricAESKey ( String masterKeyDir, String masterKeyName, String algorithm )
	        throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException
	{
		// Read the key from the specified file.
		File keyFile = new File( masterKeyDir + File.separator + masterKeyName );
		System.out.println( keyFile.getAbsolutePath( ) );
		FileInputStream keyInputStream = new FileInputStream( keyFile );
		byte [ ] encodedPrivateKey = new byte [ ( int ) keyFile.length( ) ];
		keyInputStream.read( encodedPrivateKey );
		keyInputStream.close( );
		
		// Reconstruct and return the master key.
		return new SecretKeySpec( encodedPrivateKey, "AES" );
	}
}
