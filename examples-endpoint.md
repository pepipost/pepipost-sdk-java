## Table of Content
* [fetch event logs](#example1)
* [fetch summary stats](#example2)
* [Domain Add](#example3)
* [Domain delete](#example4)
* [Suppression add](#example5)
* [Suppression delete](#example6)
* [create subaccount](#example7)
* [update subaccount](#example8)
* [enable/disable subaccount](#example9)
* [delete subaccount](#example10)
* [set recurring credit in subaccount](#example11)
* [add credit in subaccount](#example12)
* [get credit details of subaccount](#example13)

<a name="example1"></a>
## fetch event logs

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

import org.joda.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        EventsController eventsController = client.getEvents();
        
        LocalDate startdate = new LocalDate("2016-03-13");
        EventsEnum events = EventsEnum.CLICK;
        SortEnum sort = SortEnum.ASC;
        LocalDate enddate = new LocalDate("2020-05-26");
        Integer offset = 121;
        Integer limit = 1;
        String subject = "test";
        String email = "email@gmail.com";
        
        eventsController.getEventsGETAsync(startdate, events, sort, enddate, offset, limit, subject, null, null, email, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example2"></a>
## fetch summary stats 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

import org.joda.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        StatsController statsController = client.getStats();
        
        LocalDate startdate = new LocalDate("2016-03-13");
        LocalDate enddate = new LocalDate("2020-05-26");
        AggregatedByEnum aggregatedBy = AggregatedByEnum.WEEK;
        
        statsController.getStatsGETAsync(startdate, enddate, aggregatedBy, null, null, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```
<a name="example3"></a>
## Domain Add

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        DomainController domainController = client.getDomain();
        
        DomainStruct body = new DomainStruct();
        body.setDomain("example.com");
        body.setEnvelopeName("test");
        
        domainController.addDomainAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example4"></a>
## Domain delete  

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        DomainDeleteController domainDeleteController = client.getDomainDelete();
        
        DeleteDomain body = new DeleteDomain();
        body.setDomain("example.com");
        
        domainDeleteController.deleteDomainAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example5"></a>
## Suppression add 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SuppressionController suppressionController = client.getSuppression();
        
        AddEmailOrDomainToSuppressionList body = new AddEmailOrDomainToSuppressionList();
        body.setDomain("example.com");
        body.setEmail("email@gmail.com");
        
        suppressionController.addDomainOrEmailToSuppressionListAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example6"></a>
## Suppression delete 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SuppressionController suppressionController = client.getSuppression();
        
        RemoveEmailOrDomainToSuppressionList body = new RemoveEmailOrDomainToSuppressionList();
        body.setDomain("example.com");
        body.setEmail("email@gmail.com");
        
        suppressionController.removeDomainOrEmailToSuppressionListAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example7"></a>
## create subaccount 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SubaccountsCreateSubaccountController subaccountsCreateSubaccountController = client.getSubaccountsCreateSubaccount();
        
        CreateSubaccount body = new CreateSubaccount();
        body.setUsername("name");
        body.setEmail("email1.gmail.com");
        body.setSetpassword("setpassword8");
        body.setPassword("pwd");
        
        subaccountsCreateSubaccountController.createSubaccountsCreateSubaccountPOSTAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example8"></a>
## update subaccount 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SubaccountsUpdateSubaccountController subaccountsUpdateSubaccountController = client.getSubaccountsUpdateSubaccount();
        
        UpdateSubaccount body = new UpdateSubaccount();
        body.setUsername("username");
        body.setNewEmail("email@gmail.com");
        body.setNewPassword("email@gmail.com");
        body.setConfirmPassword("pwd");
        
        subaccountsUpdateSubaccountController.createSubaccountsUpdateSubaccountPOSTAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example9"></a>
## enable/disable subaccount 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SubaccountsController subaccountsController = client.getSubaccounts();
        
        EnableOrDisableSubacoount body = new EnableOrDisableSubacoount();
        body.setUsername("username");
        body.setDisabled(true);
        
        subaccountsController.updateSubaccountsPATCHAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example10"></a>
## delete subaccount 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SubaccountsDeleteController subaccountsDeleteController = client.getSubaccountsDelete();
        
        DeleteSubacoount body = new DeleteSubacoount();
        body.setUsername("username");
        
        subaccountsDeleteController.deleteSubaccountsDeleteDELETEAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example11"></a>
## set recurring credit in subaccount  

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SetrecurringcreditddetailsController setrecurringcreditddetailsController = client.getSetrecurringcreditddetails();
        
        UpdateRecurringCredisOfSubaccount body = new UpdateRecurringCredisOfSubaccount();
        body.setUsername("uername");
        body.setRecurringCredit(10);
        body.setTimeperiod(TimeperiodEnum.DAILY);
        
        setrecurringcreditddetailsController.createSetrecurringcreditddetailsPOSTAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example12"></a>
## add credit in subaccount 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SubaccountsSetsubaccountcreditController subaccountsSetsubaccountcreditController = client.getSubaccountsSetsubaccountcredit();
        
        UpdateCredisOfSubaccount body = new UpdateCredisOfSubaccount();
        body.setUsername("username");
        body.setAction(ActionEnum.DECREASE);
        body.setAmount(100);
        
        subaccountsSetsubaccountcreditController.createSubaccountsSetsubaccountcreditPOSTAsync(body, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```

<a name="example13"></a>
## get credit details of subaccount 

```java
package com.example;

import java.util.*;
import java.io.*;

import com.pepipost.api.*;
import com.pepipost.api.models.*;
import com.pepipost.api.controllers.*;
import com.pepipost.api.http.client.*;

public class Program {

    public static void main(String[] args) {
        Configuration.apiKey = "your api_key here";
        PepipostClient client = new PepipostClient();
        SubaccountsGetSubAccountsController subaccountsGetSubAccountsController = client.getSubaccountsGetSubAccounts();
        
        String limit = "100";
        String offset = "0";
        
        subaccountsGetSubAccountsController.getSubaccountsGetSubAccountsGETAsync(limit, offset, new APICallBack<Object>() {
            public void onSuccess(HttpContext context, Object response) {
                // TODO success callback handler
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
            }
        });
    }
}
```