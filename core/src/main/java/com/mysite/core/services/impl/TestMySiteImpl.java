package com.mysite.core.services.impl;

import com.mysite.core.services.TestMySite;
import org.osgi.service.component.annotations.Component;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Component(service = TestMySite.class)
public class TestMySiteImpl implements TestMySite {

    @Override
    public String Day1() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        return timeStamp;
    }
}
