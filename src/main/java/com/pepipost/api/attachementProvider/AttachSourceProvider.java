package com.pepipost.api.attachementProvider;

import java.util.List;

import com.pepipost.api.exceptions.APIException;
import com.pepipost.api.models.EmailBodyAttachments;
import com.pepipost.api.models.FileObjects;

/**
 * Interface for 3rd party attachement providers.
 * @author d.chaudhary
 *
 */
public interface AttachSourceProvider
{
	/**
	 * Interface method to return list of EmailBodyAttachments for a given list of folder/files.
	 * @param fileObjectsList
	 * @return
	 * @throws APIException
	 */
	public List< EmailBodyAttachments > getFileObjects ( List< FileObjects > fileObjectsList ) throws APIException;
	
	/**
	 * Interface method to return name of attachment provider.
	 * @return
	 */
	public String getAttachSourceProviderName ( );
	
	/**
	 * Interface method to check for Max File Size.
	 */
	public void checkMaxFileSizeExceeded(long max_file_size, long current_file_size) throws APIException;
	
}
