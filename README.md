# Pepipost Java SDK

This is a JavaSDK/Client for Pepipost's API.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation


```shell

mkdir pepipost-sdk-java

cd pepipost-sdk-java

git clone https://github.com/pepipost-sdk-java .

mvn install

```

Now create the Example.java (put the values of API key, email, etc as per your requirements)

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.EmailApi;

import java.io.File;
import java.util.*;

public class Example {

    public static void main(String[] args) {
        //Getting the SDK object
        EmailApi pepipostSDK = new EmailApi();

        //Getting the data object
        Emailv1 data = new Emailv1(); // Emailv1 | Data in JSON format

        //setting the apikey
        data.setApiKey("yoursecretapikey");

        //setting the data
        EmailDetails email_details = new EmailDetails(); // Emailv1 | Data in JSON format
        email_details.setFromname("yourfromname");
        email_details.setFrom("from@example.com");
        email_details.subject("This is the test email subject sent via Pepipost Java SDK");
        email_details.setContent("<p> hi, this is a test email sent via Pepipost Java SDK using its JSON API.</p>");
        data.setEmailDetails(email_details);

        //adding recipients
        List<String> recipients = new ArrayList<String>();
        recipients.add("to@example.com");
        data.setRecipients(recipients);

        //making the call
        try {
            pepipostSDK.apiWebSendJsonPost(data);
            System.out.println("Email sent successfully.");
        } catch (ApiException e) {
            System.out.println("Exception occurred while calling Pepipost API");
            System.out.println("Errormessage("+e.getMessage()+")");
            System.out.println("Errorcode("+e.getCode()+")");
            //e.printStackTrace();
        }
    }
}

```
Compile the Example.java
```
javac -cp '.:target/swagger-java-client-1.0.0.jar:target/lib/*' Example.java
```
Now run
```
java -cp '.:target/swagger-java-client-1.0.0.jar:target/lib/*' Example
```

To get your api key, you need to signup at [Pepipost.com](http://pepipost.com/)

## Documentation for API Endpoints

For API documentation, please visit the below url:

[**docs.pepipost.com**](docs/EmailApi.md#apiWebSendJsonPost) 


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author
[Tabby](http://github.com/itabrezshaikh)

Thanks to Swagger Codegen Project. This library has been semi-automatically generated using [swagger codegen project](https://github.com/swagger-api/swagger-codegen)



