package com.sample.extensions;

import com.sample.annotations.Wait;
import com.sample.utils.WaitConfig;
import com.sample.utils.WaitUtils;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WaitExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Wait waitAnnotation = extensionContext.getRequiredTestClass().getSuperclass().getAnnotation(Wait.class);

        WaitUtils.setWaitConfiguration(WaitConfig.builder()
                .defaultImplicitTimeUnit(waitAnnotation.timeUnit())
                .defaultExplicitTimeout(waitAnnotation.explicit())
                .defaultImplicitTimeout(waitAnnotation.implicit())
                .build());
    }
}
