package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.Calendar;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Practice {
    public String getNumber() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String dummy = String.valueOf(year);
        return dummy;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ValueMapValue
   //public int getNumber();
    private String number;




}
