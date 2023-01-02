package com.sample.extensions;

import com.sample.annotations.Browser;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

public class BrowserExtension implements BeforeAllCallback, BeforeEachCallback {

    private static final ExtensionContext.Namespace BROWSER_NAMESPACE =
            ExtensionContext.Namespace.create(BrowserExtension.class);
    private static final String BROWSER_KEY = "browser";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Optional<Browser> classBrowserAnnotation = findAnnotation(extensionContext.getRequiredTestClass(), Browser.class);

        if (classBrowserAnnotation.isEmpty())
            throw new IllegalStateException("@Browser annotation is required for all tests classes");

        extensionContext.getStore(BROWSER_NAMESPACE).put(BROWSER_KEY, classBrowserAnnotation.get());
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Browser browserAnnotation = extensionContext.getStore(BROWSER_NAMESPACE).get(BROWSER_KEY, Browser.class);
        Optional<Browser> methodBrowserAnnotation = findAnnotation(extensionContext.getRequiredTestMethod(), Browser.class);

        if (methodBrowserAnnotation.isPresent())
            browserAnnotation = methodBrowserAnnotation.get();

        browserAnnotation.browser().setup();
    }
}
