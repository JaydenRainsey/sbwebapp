package com.rev.pms.annonations;

import com.rev.pms.model.Role;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Authorized {
    public Role[] allowedRoles() default {};
    // This annotation will have an allowedRoles field that is of type Role[]
    // If this annotation is not provided a value for this field, it will have
    // an empty array
	
}
