package com.mysite.core.models;

import com.adobe.xfa.Int;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class practice1 {
    @ValueMapValue
    private String Firstname;
    @ValueMapValue
    private String Lastname;

    public String getFirstname()  {
    if (Firstname== "Dharma");    {
        Firstname= "Hello Dharma"+ "Teja ";
        }


        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
