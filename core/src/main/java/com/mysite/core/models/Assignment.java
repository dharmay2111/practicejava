package com.mysite.core.models;

import com.mysite.core.services.TestMySite;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Assignment {
    @ValueMapValue
    private String Firstname;
    @OSGiService
    TestMySite testMySite;


    public String getFirstname() {
        return testMySite.Day1();
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
}
