package com.sample.annotations;

import com.sample.extensions.WaitExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(WaitExtension.class)
public @interface Wait {
    TimeUnit timeUnit() default MILLISECONDS;

    int implicit() default 5000;

    int explicit() default 5000;
}
