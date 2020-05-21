## Advanced Usage

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

    public static void main(String[] args) throws IOException {
        
        PepipostClient client = new PepipostClient();
        SendController sendController = client.getSend();
        Configuration.apiKey = "your api_key here";
        Send body = new Send();
        body.setReplyTo("you-reply-to-id-address@mydomain.name");
        body.setFrom(new From());
        body.getFrom().setEmail("hello@your-register-domain-with-pepipost");
        body.getFrom().setName("Example Pepi");
        body.setSubject("Emailing with Pepipost is easy [%LANG%]");
        body.setTemplateId(0L);
        body.setContent(new LinkedList<Content>());
        
        Content body_content_0 = new Content();
        body_content_0.setType(TypeEnum.HTML);
        body_content_0.setValue("<html><body>Hey,<br><br>Do you know integration is even simpler in Pepipost, <br>with Java <br> Happy Mailing ! <br><br>Pepipost </body></html>");
        body.getContent().add(body_content_0);
        
        body.setAttachments(new LinkedList<Attachments>());
        
        Attachments body_attachments_0 = new Attachments();
        body_attachments_0.setContent("SGVsbG8gd2VsY29tZSB0byBQRVBJIHY1IEFQSQ==");
        body_attachments_0.setName("global-text-file.txt");
        body.getAttachments().add(body_attachments_0);
        
        body.setPersonalizations(new LinkedList<Personalizations>());
        
        Personalizations body_personalizations_0 = new Personalizations();
        body_personalizations_0.setAttributes(com.pepipost.api.APIHelper.deserialize("{\"LANG\":\"JAVA\"}"));
        body_personalizations_0.setHeaders(com.pepipost.api.APIHelper.deserialize("{\"key\":\"value\"}"));
        body_personalizations_0.setAttachments(new LinkedList<Attachments>());
        
        Attachments body_personalizations_0_attachments_0 = new Attachments();
        body_personalizations_0_attachments_0.setContent("SGVsbG8gd2VsY29tZSB0byBQRVBJIHY1IEFQSQ==");
        body_personalizations_0_attachments_0.setName("personalized-test-file.txt");
        body_personalizations_0.getAttachments().add(body_personalizations_0_attachments_0);
        
        body_personalizations_0.setTo(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_0_to_0 = new EmailStruct();
        body_personalizations_0_to_0.setName("random-1");
        body_personalizations_0_to_0.setEmail("random-1@mydomain.name");
        body_personalizations_0.getTo().add(body_personalizations_0_to_0);
        
        body_personalizations_0.setCc(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_0_cc_0 = new EmailStruct();
        body_personalizations_0_cc_0.setName("random-cc");
        body_personalizations_0_cc_0.setEmail("random-cc@mydomain.name");
        body_personalizations_0.getCc().add(body_personalizations_0_cc_0);
        
        body_personalizations_0.setBcc(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_0_bcc_0 = new EmailStruct();
        body_personalizations_0_bcc_0.setName("random-bcc");
        body_personalizations_0_bcc_0.setEmail("random-bcc@mydomain.name");
        body_personalizations_0.getBcc().add(body_personalizations_0_bcc_0);
        
        body_personalizations_0.setTokenTo("{\"Arg1\":\"Value1\"}");
        body_personalizations_0.setTokenCc("{\"Arg1\":\"Value1\"}");
        body_personalizations_0.setTokenBcc("{\"Arg1\":\"Value1\"}");
        body.getPersonalizations().add(body_personalizations_0);
        
        Personalizations body_personalizations_1 = new Personalizations();
        body_personalizations_1.setAttributes(com.pepipost.api.APIHelper.deserialize("{\"key\":\"value\"}"));
        body_personalizations_1.setHeaders(com.pepipost.api.APIHelper.deserialize("{\"key\":\"value\"}"));
        body_personalizations_1.setAttachments(new LinkedList<Attachments>());
        
        Attachments body_personalizations_1_attachments_0 = new Attachments();
        body_personalizations_1_attachments_0.setContent("SGVsbG8gd2VsY29tZSB0byBQRVBJIHY1IEFQSQ==");
        body_personalizations_1_attachments_0.setName("personalized-test-file.txt");
        body_personalizations_1.getAttachments().add(body_personalizations_1_attachments_0);
        
        body_personalizations_1.setTo(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_1_to_0 = new EmailStruct();
        body_personalizations_1_to_0.setName("random-1");
        body_personalizations_1_to_0.setEmail("random-1@mydomain.name");
        body_personalizations_1.getTo().add(body_personalizations_1_to_0);
        
        body_personalizations_1.setCc(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_1_cc_0 = new EmailStruct();
        body_personalizations_1_cc_0.setName("random-cc");
        body_personalizations_1_cc_0.setEmail("random-cc@mydomain.name");
        body_personalizations_1.getCc().add(body_personalizations_1_cc_0);
        
        body_personalizations_1.setBcc(new LinkedList<EmailStruct>());
        
        EmailStruct body_personalizations_1_bcc_0 = new EmailStruct();
        body_personalizations_1_bcc_0.setName("random-bcc");
        body_personalizations_1_bcc_0.setEmail("random-bcc@mydomain.name");
        body_personalizations_1.getBcc().add(body_personalizations_1_bcc_0);
        
        body.getPersonalizations().add(body_personalizations_1);
        
        body.setSettings(new Settings());
        body.getSettings().setFooter(true);
        body.getSettings().setClickTrack(true);
        body.getSettings().setOpenTrack(true);
        body.getSettings().setUnsubscribeTrack(true);
        body.getSettings().setHepf(false);
        body.setTags(new LinkedList<String>());
        body.getTags().add("campaign");
        body.setLintPayload(true);
        body.setSchedule(0L);
        body.setBcc(new LinkedList<EmailStruct>());
        
        EmailStruct body_bcc_0 = new EmailStruct();
        body_bcc_0.setName("random-bcc");
        body_bcc_0.setEmail("random-bcc@mydomain.name");
        body.getBcc().add(body_bcc_0);
        
        
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
