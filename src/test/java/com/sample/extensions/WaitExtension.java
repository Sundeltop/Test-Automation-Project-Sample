package com.sample.extensions;

import com.sample.annotations.Wait;
import com.sample.utils.WaitConfig;
import com.sample.utils.WaitUtils;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Objects;

public class WaitExtension implements BeforeAllCallback, BeforeEachCallback {

    private static final ExtensionContext.Namespace WAIT_NAMESPACE =
            ExtensionContext.Namespace.create(WaitExtension.class);
    private static final String WAIT_KEY = "wait";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Wait classWaitAnnotation = extensionContext.getRequiredTestClass().getAnnotation(Wait.class);
        extensionContext.getStore(WAIT_NAMESPACE).put(WAIT_KEY, classWaitAnnotation);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Wait waitAnnotation = extensionContext.getStore(WAIT_NAMESPACE).get(WAIT_KEY, Wait.class);
        Wait methodWaitAnnotation = extensionContext.getRequiredTestMethod().getAnnotation(Wait.class);
        if (Objects.nonNull(methodWaitAnnotation)) {
            waitAnnotation = methodWaitAnnotation;
        }
        WaitUtils.setWaitConfiguration(WaitConfig.builder()
                .defaultImplicitTimeUnit(waitAnnotation.timeUnit())
                .defaultExplicitTimeout(waitAnnotation.explicit())
                .defaultImplicitTimeout(waitAnnotation.implicit())
                .build());
    }
}
