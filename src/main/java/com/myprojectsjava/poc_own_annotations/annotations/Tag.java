package com.myprojectsjava.poc_own_annotations.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Repeatable(Tags.class)
public @interface Tag {
    String value();
}