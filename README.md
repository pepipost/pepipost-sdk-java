![pepipostlogo](https://pepipost.com/wp-content/uploads/2017/07/P_LOGO.png)

[![Twitter Follow](https://img.shields.io/twitter/follow/pepi_post.svg?style=social&label=Follow)](https://twitter.com/pepi_post)

# Official Java library :coffee: for [Pepipost](http://www.pepipost.com/?utm_campaign=GitHubSDK&utm_medium=GithubSDK&utm_source=GithubSDK)

This library contains methods for easily interacting with the Pepipost Email Sending API to send emails within few seconds.

We are trying to make our libraries Community Driven- which means we need your help in building the right things in proper order we would request you to help us by sharing comments, creating new [issues](https://github.com/pepipost/pepipost-sdk-java/issues) or [pull requests](https://github.com/pepipost/pepipost-sdk-java/pulls).

We welcome any sort of contribution to this library.

The latest 5.0 version of this library provides is fully compatible with the latest Pepipost v5.0 API.

For any update of this library check [Releases](https://github.com/pepipost/pepipost-sdk-java/releases).

# Table of Content
  
* [Installation](#installation)
* [Quick Start](#quick-start)
* [Usage of library in Project](#inproject)
* [Sample Example](#eg)
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
package TestApp.SimpleConsoleApp;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

import com.fasterxml.jackson.core.JsonProcessingException;


public class App {

    public static void main(String[] args) throws JsonProcessingException {
        
        PepipostClient client = new PepipostClient();
        MailSendController mailSendController = client.getMailSend();
        Configuration.apiKey = "your api_key here";
        Send body = new Send();
        
        body.setFrom(new From());
        body.getFrom().setEmail("hello@your-register-domain-with-pepipost");
        body.getFrom().setName("Example Pepi");
        body.setSubject("Emailing with Pepipost is easy");
        body.setContent(new LinkedList<Content>());
        
        Content body_content_0 = new Content();
        body_content_0.setType(TypeEnum.HTML);
        body_content_0.setValue("<html><body>Hey,<br><br>Do you know integration is even simpler in Pepipost, <br>with Java <br> Happy Mailing ! <br><br>Pepipost </body></html>");
        body.getContent().add(body_content_0);
        
        body.setPersonalizations(new LinkedList<Personalizations>());
        
        Personalizations body_personalizations_0 = new Personalizations();
        body_personalizations_0.setTo(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_0_to_0 = new EmailStruct();
        body_personalizations_0_to_0.setName("random-1");
        body_personalizations_0_to_0.setEmail("random-1@mydomain.name");
        body_personalizations_0.getTo().add(body_personalizations_0_to_0);
        
        body.getPersonalizations().add(body_personalizations_0);
        
        mailSendController.createGeneratethemailsendrequestAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                
            	System.out.println(response.toString());
            	System.out.println(context.getResponse().getStatusCode());
            	
            }
            public void onFailure(HttpContext context, Throwable error) {
            	
            	System.out.println(error.getMessage());
            	System.out.println(context.getResponse().getStatusCode());
            	

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


<a name="announcements"></a>
# Announcements

v5.0 has been released! Please see the [release notes](https://github.com/pepipost/pepipost-sdk-java/releases/) for details.

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

