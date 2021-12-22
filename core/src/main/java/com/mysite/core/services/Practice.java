package com.mysite.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Practice Configuration", description = "Practice")
public @interface Practice {
    @AttributeDefinition(name  = "username", description= "username")
    String username();
}
