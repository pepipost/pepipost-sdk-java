# EmailApi

All URIs are relative to *https://api.pepipost.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiWebSendJsonPost**](EmailApi.md#apiWebSendJsonPost) | **POST** /api/web.send.json | 
[**apiWebSendRestGet**](EmailApi.md#apiWebSendRestGet) | **GET** /api/web.send.rest | 


<a name="apiWebSendJsonPost"></a>
# **apiWebSendJsonPost**
> apiWebSendJsonPost(data)



&#x60;Sending Mails&#x60; – This API is used for sending emails. Pepipost supports REST as well JSON formats for the input. This is JSON API. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EmailApi;


EmailApi apiInstance = new EmailApi();
Emailv1 data = new Emailv1(); // Emailv1 | Data in JSON format
try {
    apiInstance.apiWebSendJsonPost(data);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailApi#apiWebSendJsonPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Emailv1**](Emailv1.md)| Data in JSON format |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiWebSendRestGet"></a>
# **apiWebSendRestGet**
> apiWebSendRestGet(apiKey, from, subject, content, recipients, fromname, replytoid, footer, template, attachmentid, clicktrack, opentrack, bcc, ATT_NAME, X_APIHEADER, tags)



&#x60;Sending Mails&#x60; – This API is used for sending emails. Pepipost supports REST as well JSON formats for the input 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EmailApi;


EmailApi apiInstance = new EmailApi();
String apiKey = "apiKey_example"; // String | Your API Key
String from = "from_example"; // String | From email address
String subject = "subject_example"; // String | Subject of the Email
String content = "content_example"; // String | Email body in html (to use attributes to display dynamic values such as name, account number, etc. for ex. [% NAME %] for ATT_NAME , [% AGE %] for ATT_AGE etc.)
String recipients = "recipients_example"; // String | Email addresses for recipients (multiple values allowed)
String fromname = "fromname_example"; // String | Email Sender name
String replytoid = "replytoid_example"; // String | Reply to email address
Boolean footer = true; // Boolean | Set '0' or '1' in order to include footer or not
Integer template = 56; // Integer | Email template ID
String attachmentid = "attachmentid_example"; // String | specify uploaded attachments id (Multiple attachments are allowed)
Boolean clicktrack = true; // Boolean | set ‘0’ or ‘1’ in-order to disable or enable the click-track
Boolean opentrack = true; // Boolean | set open-track value to ‘0’ or ‘1’ in-order to disable or enable
String bcc = "bcc_example"; // String | Email address for bcc
String ATT_NAME = "ATT_NAME_example"; // String | Specify attributes followed by ATT_ for recipient to personalized email for ex. ATT_NAME for name, ATT_AGE for age etc. (Multiple attributes are allowed)
String X_APIHEADER = "X_APIHEADER_example"; // String | Your defined unique identifier
String tags = ""; // String | To relate each message. Useful for reports.
try {
    apiInstance.apiWebSendRestGet(apiKey, from, subject, content, recipients, fromname, replytoid, footer, template, attachmentid, clicktrack, opentrack, bcc, ATT_NAME, X_APIHEADER, tags);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailApi#apiWebSendRestGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| Your API Key |
 **from** | **String**| From email address |
 **subject** | **String**| Subject of the Email |
 **content** | **String**| Email body in html (to use attributes to display dynamic values such as name, account number, etc. for ex. [% NAME %] for ATT_NAME , [% AGE %] for ATT_AGE etc.) |
 **recipients** | **String**| Email addresses for recipients (multiple values allowed) |
 **fromname** | **String**| Email Sender name | [optional]
 **replytoid** | **String**| Reply to email address | [optional]
 **footer** | **Boolean**| Set &#39;0&#39; or &#39;1&#39; in order to include footer or not | [optional] [default to true]
 **template** | **Integer**| Email template ID | [optional]
 **attachmentid** | **String**| specify uploaded attachments id (Multiple attachments are allowed) | [optional]
 **clicktrack** | **Boolean**| set ‘0’ or ‘1’ in-order to disable or enable the click-track | [optional] [default to true]
 **opentrack** | **Boolean**| set open-track value to ‘0’ or ‘1’ in-order to disable or enable | [optional] [default to true]
 **bcc** | **String**| Email address for bcc | [optional]
 **ATT_NAME** | **String**| Specify attributes followed by ATT_ for recipient to personalized email for ex. ATT_NAME for name, ATT_AGE for age etc. (Multiple attributes are allowed) | [optional]
 **X_APIHEADER** | **String**| Your defined unique identifier | [optional]
 **tags** | **String**| To relate each message. Useful for reports. | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

