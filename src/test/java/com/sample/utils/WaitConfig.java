package com.sample.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WaitConfig {

    private TimeUnit defaultImplicitTimeUnit;
    private int defaultImplicitTimeout;
    private int defaultExplicitTimeout;
}
