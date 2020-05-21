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
        SendController sendController = client.getSend();
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
        
        sendController.createGenerateTheMailSendRequestAsync(body, new APICallBack<Object>() {
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