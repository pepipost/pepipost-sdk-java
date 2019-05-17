![pepipostlogo](https://pepipost.com/assets/img/pepipost-footLogo.png)

[![Twitter Follow](https://img.shields.io/twitter/follow/pepi_post.svg?style=social&label=Follow)](https://twitter.com/pepi_post)

# Official Java library :coffee: for [Pepipost](http://www.pepipost.com/?utm_campaign=GitHubSDK&utm_medium=GithubSDK&utm_source=GithubSDK)

This library contains methods for easily interacting with the Pepipost Email Sending API to send emails within few seconds.

We are trying to make our libraries Community Driven- which means we need your help in building the right things in proper order we would request you to help us by sharing comments, creating new [issues](https://github.com/pepipost/pepipost-sdk-java/issues) or [pull requests](https://github.com/pepipost/pepipost-sdk-java/pulls).

We welcome any sort of contribution to this library.

The latest 2.5.0 version of this library provides is fully compatible with the latest Pepipost v2.0 API.

For any update of this library check [Releases](https://github.com/pepipost/pepipost-sdk-java/releases).

# Table of Content
  
* [Installation](#installation)
* [Quick Start](#quick-start)
* [Usage of library in Project](#inproject)
* [Sample Example](#eg)
* [S3 Sample Example](#s3)
* [Announcements](#announcements)
* [Roadmap](#roadmap)
* [About](#about)
* [License](#license)

<a name="installation"></a>
# Installation

<a name="prereq"></a>
## Prerequisites
* Java version Oracle JDK 7, 8 or OpenJDK 7
* Java Maven Dependencies
  * Jackson
  * UniRest
  * Apache HttpClient
* Java Development Enviromment (IDE).
* A free account on Pepipost. If you don't have a one, click [here]((https://app.pepipost.com/index.php/signup/registeruser?utm_campaign=GitHubSDK&utm_medium=GithubSDK&utm_source=GithubSDK)) to signup and get 30,000 emails free every month.

<a name="quickstart"></a>
## Quick Start

This Java library uses few Maven Dependencies ([mentioned above](#prereq)). The reference to these dependencies are added in pom.xml file which will be installed automatically. Just need internet access for successful build.

* [Download zip](https://github.com/pepipost/pepipost-sdk-java/archive/master.zip) or get a clone for the pepipost repository using 

  ``` git clone https://github.com/pepipost/pepipost-sdk-java.git ```

* In order to open the client library in Eclipse click on ``` File -> Import ```.

  ![Importing SDK into Eclipse - Step 1](https://apidocs.io/illustration/java?step=import0&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

* In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

  ![Importing SDK into Eclipse - Step 2](https://apidocs.io/illustration/java?step=import1&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

* Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

  ![Importing SDK into Eclipse - Step 3](https://apidocs.io/illustration/java?step=import2&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

  ![Importing SDK into Eclipse - Step 4](https://apidocs.io/illustration/java?step=import3&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

<a name="inproject"></a>
### Usage of Pepipost library in project

1. Starting a new project

   * Click the menu command ``` File > New > Project ```.

     ![Add a new project in Eclipse](https://apidocs.io/illustration/java?step=createNewProject0&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

   * Choose ``` Maven > Maven Project ```.
   
   * Click ``` Next ```.

     ![Create a new Maven Project - Step 1](https://apidocs.io/illustration/java?step=createNewProject1&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

   * Here, make sure to use the current workspace by choosing ``` Use default Workspace location ```, as shown in the screenshot below.
   
   * Click ``` Next ```.

     ![Create a new Maven Project - Step 2](https://apidocs.io/illustration/java?step=createNewProject2&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

   * Select the *quick start* project type to create a simple project with an existing class.
   * A ``` main ``` method. 
   * To do this, choose ``` maven-archetype-quickstart ``` item from the list.
   * Click ``` Next ```.

     ![Create a new Maven Project - Step 3](https://apidocs.io/illustration/java?step=createNewProject3&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

   * In the last step, provide a ``` Group Id ```.and ``` Artifact Id ``` as shown in the picture below.
   * Click ``` Finish ```.

     ![Create a new Maven Project - Step 4](https://apidocs.io/illustration/java?step=createNewProject4&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

2. Add reference of the library project

   * The created Maven project manages its dependencies using its ``` pom.xml ``` file.
   * In order to add a dependency on the **PepipostLib** client library, double click on the ``` pom.xml ``` file in the ``` Package Explorer ```. 
   * Opening the ``` pom.xml ``` file will render a graphical view on the canvas.
   * Here, switch to the ``` Dependencies ``` tab.
   * Click the ``` Add ``` button as shown in the picture below.

     ![Adding dependency to the client library - Step 1](https://apidocs.io/illustration/java?step=testProject0&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

   * Click the ``` Add ``` button. A dialog will open, where you need to specify Pepipost in ``` Group Id ``` and PepipostLib in the ``` Artifact Id ``` fields.
   * Once added click ``` OK ```. 
   * Save the ``` pom.xml ``` file.

     ![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject1&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

3. Getting started with code

   * Once the ``` SimpleConsoleApp ``` is created, a file named ``` App.java ``` will be visible in the *Package Explorer* with a ``` main ``` method. 
   * This is the entry point for the execution of the created project.

     ![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject2&workspaceFolder=pepipost-Java&workspaceName=Pepipost&projectName=PepipostLib&rootNamespace=com.pepipost.api)

<a name="eg"></a>
## Sample Usage

```java
package testApp.SimpleConsoleApp;
import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public class App {

    public static void main(String[] args) throws JsonProcessingException {

        PepipostClient client = new PepipostClient();

        EmailController emailController = client.getEmail();
        String apiKey = "my-api-here";
        EmailBody body = new EmailBody();

        body.setPersonalizations(new LinkedList<Personalizations>());
        Personalizations body_personalizations_0 = new Personalizations();

        body_personalizations_0.setRecipient("your-rcpt_email@gmail.com");
        body.getPersonalizations().add(body_personalizations_0);
        body.setTags("tagsjava");
        body.setFrom(new From());

        body.getFrom().setFromEmail("my-verified-domain@m3m.in");
        body.getFrom().setFromName("info");
        body.setSubject("JAVA SDK");
        body.setContent("Test mail ready to sent");
        body.setSettings(new Settings());

        body.getSettings().setFooter(0);
        body.getSettings().setClicktrack(1);
        body.getSettings().setOpentrack(1);
        body.getSettings().setUnsubscribe(1);
        

        emailController.createSendEmailAsync(apiKey, body,"/v2/sendEmail", new APICallBack<SendEmailResponse>() {
            public void onSuccess(HttpContext context, SendEmailResponse response) {
                // TODO success callback handler
            	System.out.print("Message :: " + response.getMessage() + "\n" + "Error :: " + response.getErrorInfo().getErrorMessage());
            }
            public void onFailure(HttpContext context, Throwable error) {
            	System.out.print(context.getResponse());
            }
            
         });
    }
}

```
* Change your api-key and sending domain respectively
  * **apikey** will be available under Login to Pepipost -> Settings -> Integration  
  * **Sending Domain** will be available under Login to Pepiost -> Settings -> Sending Domains 
  
```
  *Note :: Domains showing with Active status on Sending Domain dashboard are only allowed to send any sort of emails.* In case there are no Sending Domain added under your account, then first add the domain, get the DNS (SPF/DKIM) settings done and get it reviewed by our compliance team for approval. Once the domain is approved, it will be in ACTIVE status and will be ready to send any sort of emails. 
```
* Run your project

<a name="s3"></a>
## S3 Sample 

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.pepipost.api.PepipostClient;
import com.pepipost.api.attachementProvider.AttachSourceProvider;
import com.pepipost.api.attachementProvider.S3AttachSourceProvider;
import com.pepipost.api.controllers.EmailController;
import com.pepipost.api.exceptions.APIException;
import com.pepipost.api.http.client.APICallBack;
import com.pepipost.api.http.client.HttpContext;
import com.pepipost.api.models.EmailBody;
import com.pepipost.api.models.FileObjects;
import com.pepipost.api.models.From;
import com.pepipost.api.models.Personalizations;
import com.pepipost.api.models.SendEmailResponse;
import com.pepipost.api.models.Settings;

public class TesterDriver
{
	
	public static void main ( String [ ] args ) throws APIException
	{
		
		PepipostClient client = new PepipostClient( );
		
		EmailController emailController = client.getEmail( );
		String apiKey = "my-api-here";
		EmailBody body = new EmailBody( );
		
		body.setPersonalizations( new LinkedList< Personalizations >( ) );
		Personalizations body_personalizations_0 = new Personalizations( );
		
		body_personalizations_0.setRecipient( "your-rcpt_email@gmail.com" );
		body.getPersonalizations( ).add( body_personalizations_0 );
		body.setTags( "tagsjava" );
		body.setFrom( new From( ) );
		
		body.getFrom( ).setFromEmail( "my-verified-domain@m3m.in" );
		body.getFrom( ).setFromName( "info" );
		body.setSubject( "JAVA SDK 3.0 w/ AWS ok encrypted content." );
		body.setContent( "Test mail ready to sent" );
		body.setSettings( new Settings( ) );
		
		/* list of files in specific bucket. */
		// 2 files in same bucket. They have no encryption applied.
		List< String > filesList = new ArrayList< String >( );
		filesList.add( "jcp.PNG" );
		filesList.add( "dlfine.pdf" );
		FileObjects fileObjects_1 = new FileObjects( "pepipostawsinteg", filesList );
		fileObjects_1.setEncyrptionType( "NONE" );
		
		// 2 files in same bucket. They have no encryption applied.
		List< String > filesList_2 = new ArrayList< String >( );
		filesList_2.add( "BW_MEMO2-typeable.pdf" );
		filesList_2.add( "baz.enc" );
		// filesList_2.add( "Microservices_Patterns_v11.pdf" );
		FileObjects fileObjects_2 = new FileObjects( "myotherbucketforpepi", filesList_2 );
		fileObjects_2.setEncyrptionType( "NONE" );
		
		// A file in a bucket. Before uploading, the file was encyrpted using
		// AWS KMS key with AWS S3 SDK.
		// hence we need respective client to download / decrypt the data before
		// document is email attach ready.
		List< String > kms_encryptedFileList = new ArrayList< String >( );
		kms_encryptedFileList.add( "enc_file_kms.txt" );
		FileObjects kms_enc_files = new FileObjects( "myotherbucketforpepi", kms_encryptedFileList );
		kms_enc_files.setEncyrptionType( "AWSKMS" );
		kms_enc_files.setKms_cmk_id( "7c232025-9498-4959-83e5-153345e50ee5" );
		
		// A file in a bucket. Before uploading, the file was encyrpted using
		// AES Symmetric key with AWS S3 SDK.
		// hence we need respective client to download / decrypt the data before
		// document is email attach ready.
		List< String > aes_encryptedFileList = new ArrayList< String >( );
		aes_encryptedFileList.add( "enc_file_aes256.txt" );
		FileObjects aes_enc_files = new FileObjects( "myotherbucketforpepi", aes_encryptedFileList );
		aes_enc_files.setEncyrptionType( "AES" );
		aes_enc_files.setPath_to_keys( System.getProperty( "java.io.tmpdir" ) );
		aes_enc_files.setAes_master_keyName( "secret.key" );
		
		// A file in a bucket. Before uploading, the file was encyrpted using
		// RSA Asymmetric keys(pub / private) with AWS S3 SDK.
		// hence we need respective client to download / decrypt the data before
		// document is email attach ready.
		List< String > rsa_encryptedFileList = new ArrayList< String >( );
		rsa_encryptedFileList.add( "enc_file_rsa10241.txt" );
		FileObjects rsa_enc_files = new FileObjects( "myotherbucketforpepi", rsa_encryptedFileList );
		rsa_enc_files.setEncyrptionType( "RSA" );
		rsa_enc_files.setPath_to_keys( System.getProperty( "java.io.tmpdir" ) );
		rsa_enc_files.setRsa_pub_keyName( "public.key" );
		rsa_enc_files.setRsa_pvt_keyName( "private.key" );
		
		/* list of all buckets. User might use multiple buckets. */
		List< FileObjects > fileObjectsList = new ArrayList< FileObjects >( );
		fileObjectsList.add( fileObjects_1 );
		fileObjectsList.add( fileObjects_2 );
		fileObjectsList.add( kms_enc_files );
		fileObjectsList.add( aes_enc_files );
		fileObjectsList.add( rsa_enc_files );
		
		AttachSourceProvider awsSourceProvider = null;
		
		try
		{
			/*
			 * invoke source provider per region. For different regions,
			 * instantiate seperate sourceProvider instances. do not mix
			 * fileObjectsList for different regions. They need seperate auth.
			 */
			awsSourceProvider = new S3AttachSourceProvider( "us-east-2", 10 );
			body.setAttachments( awsSourceProvider.getFileObjects( fileObjectsList ) );
		}
		catch ( APIException apiEx )
		{
			throw apiEx;
		}
		
		body.getSettings( ).setFooter( 0 );
		body.getSettings( ).setClicktrack( 1 );
		body.getSettings( ).setOpentrack( 1 );
		body.getSettings( ).setUnsubscribe( 1 );
		
		emailController.createSendEmailAsync( apiKey, body,"/v2/sendEmail", new APICallBack< SendEmailResponse >( )
		{
			public void onSuccess ( HttpContext context, SendEmailResponse response )
			{
				// TODO success callback handler
				System.out.print( "Message :: " + response.getMessage( ) + "\n" + "Error :: "
				        + response.getErrorInfo( ).getErrorMessage( ) );
			}
			
			public void onFailure ( HttpContext context, Throwable error )
			{
				System.out.print( context.getResponse( ) );
			}
			
		} );
	}
	
}
```


<a name="announcements"></a>
# Announcements

v2.5.0 has been released! Please see the [release notes](https://github.com/pepipost/pepipost-sdk-java/releases/) for details.

All updates to this library are documented in our [releases](https://github.com/pepipost/pepipost-sdk-java/releases). For any queries, feel free to reach out us at dx@pepipost.com

<a name="roadmap"></a>
## Roadmap

If you are interested in the future direction of this project, please take a look at our open [issues](https://github.com/pepipost/pepipost-sdk-java/issues) and [pull requests](https://github.com/pepipost/pepipost-sdk-java/pulls). We would love to hear your feedback.

<a name="about"></a>
## About
pepipost-sdk-java library is guided and supported by the [Pepipost Developer Experience Team](https://github.com/orgs/pepipost/teams/pepis/members) .
This pepipost library is maintained and funded by Pepipost Ltd. The names and logos for pepipost gem are trademarks of Pepipost Ltd.

<a name="license"></a>
## License
This code library was semi-automatically generated by APIMATIC v2.0 and licensed under The MIT License (MIT).

