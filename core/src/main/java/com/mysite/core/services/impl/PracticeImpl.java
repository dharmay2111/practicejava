package com.mysite.core.services.impl;

import com.mysite.core.services.Practice;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import java.lang.annotation.Annotation;

@Component(service = Practice.class, immediate = true)
@Designate(ocd=Practice.class)
public class PracticeImpl implements Practice {
    private Practice practice;
    @Activate
    protected void activate(Practice practice){this.practice=practice; }

    @Override
    public String username(){return this.practice.username();}

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
