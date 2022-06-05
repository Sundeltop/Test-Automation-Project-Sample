package com.sample.extensions;

import com.sample.annotations.Browser;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Objects;

public class BrowserExtension implements BeforeAllCallback, BeforeEachCallback {

    private static final ExtensionContext.Namespace BROWSER_NAMESPACE =
            ExtensionContext.Namespace.create(BrowserExtension.class);
    private static final String BROWSER_KEY = "browser";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Browser classBrowserAnnotation = extensionContext.getRequiredTestClass().getAnnotation(Browser.class);
        if (Objects.isNull(classBrowserAnnotation)) {
            classBrowserAnnotation = extensionContext.getRequiredTestClass()
                    .getSuperclass().getAnnotation(Browser.class);
        }
        extensionContext.getStore(BROWSER_NAMESPACE).put(BROWSER_KEY, classBrowserAnnotation);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Browser browserAnnotation = extensionContext.getStore(BROWSER_NAMESPACE).get(BROWSER_KEY, Browser.class);
        Browser methodBrowserAnnotation = extensionContext.getRequiredTestMethod().getAnnotation(Browser.class);
        if (Objects.nonNull(methodBrowserAnnotation)) {
            browserAnnotation = methodBrowserAnnotation;
        }
        browserAnnotation.browser().setup();
    }
}
