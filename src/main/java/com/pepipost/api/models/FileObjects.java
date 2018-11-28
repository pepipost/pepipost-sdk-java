package com.pepipost.api.models;

import java.util.List;

public class FileObjects
{
	String folderName;
	
	List<String> fileLists;
	
	String fileContent;
	
	String encryptionType;
	
	String path_to_keys;
	
	String rsa_pub_keyName;
	
	String rsa_pvt_keyName;
	
	String aes_master_keyName;
	
	String kms_cmk_id;
	
	public FileObjects(String folderName, List<String> fileLists)
	{
		this.folderName = folderName;
		this.fileLists = fileLists;
	}

	/**
	 * @return the folderName
	 */
	public String getFolderName ( )
	{
		return folderName;
	}

	/**
	 * @param folderName the folderName to set
	 */
	public void setFolderName ( String folderName )
	{
		this.folderName = folderName;
	}

	/**
	 * @return the fileLists
	 */
	public List< String > getFileLists ( )
	{
		return fileLists;
	}

	/**
	 * @param fileLists the fileLists to set
	 */
	public void setFileLists ( List< String > fileLists )
	{
		this.fileLists = fileLists;
	}

	/**
	 * @return the fileContent
	 */
	public String getFileContent ( )
	{
		return fileContent;
	}

	/**
	 * @param fileContent the fileContent to set
	 */
	public void setFileContent ( String fileContent )
	{
		this.fileContent = fileContent;
	}

	/**
	 * @return the encyrptionType
	 */
	public String getEncyrptionType ( )
	{
		return encryptionType;
	}

	/**
	 * @param encyrptionType the encyrptionType to set
	 */
	public void setEncyrptionType ( String encyrptionType )
	{
		this.encryptionType = encyrptionType;
	}

	/**
	 * @return the path_to_keys
	 */
	public String getPath_to_keys ( )
	{
		return path_to_keys;
	}

	/**
	 * @param path_to_keys the path_to_keys to set
	 */
	public void setPath_to_keys ( String path_to_keys )
	{
		this.path_to_keys = path_to_keys;
	}

	/**
	 * @return the rsa_pub_keyName
	 */
	public String getRsa_pub_keyName ( )
	{
		return rsa_pub_keyName;
	}

	/**
	 * @param rsa_pub_keyName the rsa_pub_keyName to set
	 */
	public void setRsa_pub_keyName ( String rsa_pub_keyName )
	{
		this.rsa_pub_keyName = rsa_pub_keyName;
	}

	/**
	 * @return the rsa_pvt_keyName
	 */
	public String getRsa_pvt_keyName ( )
	{
		return rsa_pvt_keyName;
	}

	/**
	 * @param rsa_pvt_keyName the rsa_pvt_keyName to set
	 */
	public void setRsa_pvt_keyName ( String rsa_pvt_keyName )
	{
		this.rsa_pvt_keyName = rsa_pvt_keyName;
	}

	/**
	 * @return the aes_master_keyName
	 */
	public String getAes_master_keyName ( )
	{
		return aes_master_keyName;
	}

	/**
	 * @param aes_master_keyName the aes_master_keyName to set
	 */
	public void setAes_master_keyName ( String aes_master_keyName )
	{
		this.aes_master_keyName = aes_master_keyName;
	}

	/**
	 * @return the kms_cmk_id
	 */
	public String getKms_cmk_id ( )
	{
		return kms_cmk_id;
	}

	/**
	 * @param kms_cmk_id the kms_cmk_id to set
	 */
	public void setKms_cmk_id ( String kms_cmk_id )
	{
		this.kms_cmk_id = kms_cmk_id;
	}
}
