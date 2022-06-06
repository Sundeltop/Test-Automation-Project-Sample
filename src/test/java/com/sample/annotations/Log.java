package com.sample.annotations;

import com.sample.extensions.LoggerExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ExtendWith(LoggerExtension.class)
public @interface Log {
}
