package com.sample.annotations;

import com.automation.remarks.junit5.Video;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Video
@Screenshot
public @interface Evidence {
}
