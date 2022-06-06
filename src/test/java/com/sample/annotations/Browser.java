package com.sample.annotations;

import com.sample.enums.BrowserType;
import com.sample.extensions.BrowserExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

import static com.sample.enums.BrowserType.CHROME;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ExtendWith(BrowserExtension.class)
public @interface Browser {
    BrowserType browser() default CHROME;
}
