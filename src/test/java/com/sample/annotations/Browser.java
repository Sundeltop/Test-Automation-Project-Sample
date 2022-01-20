package com.sample.annotations;

import com.sample.extensions.BrowserExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.sample.annotations.Browser.BrowserType.chrome;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(BrowserExtension.class)
public @interface Browser {

    BrowserType browser() default chrome;

    enum BrowserType {
        chrome, edge
    }

}
