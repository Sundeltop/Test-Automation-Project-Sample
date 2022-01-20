package com.sample.extensions;

import com.sample.annotations.Browser;
import com.sample.utils.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

public class BrowserExtension implements BeforeAllCallback, BeforeEachCallback {

    public static final ExtensionContext.Namespace browserNamespace = ExtensionContext.Namespace.create(BrowserExtension.class);
    private static final String BROWSER_KEY = "browser";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Browser browser = extensionContext.getRequiredTestClass().getAnnotation(Browser.class);
        extensionContext.getStore(browserNamespace).put(BROWSER_KEY, browser);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Browser browserAnnotation = extensionContext.getStore(browserNamespace).get(BROWSER_KEY, Browser.class);
        Browser methodBrowserAnnotation = extensionContext.getRequiredTestMethod().getAnnotation(Browser.class);
        if (Objects.nonNull(methodBrowserAnnotation)) {
            browserAnnotation = methodBrowserAnnotation;
        }
        switch (browserAnnotation.browser()) {
            case chrome -> {
                WebDriverManager.chromedriver().setup();
                WebDriverConfig.setWebDriver(new ChromeDriver());
            }
            case edge -> {
                WebDriverManager.edgedriver().setup();
                WebDriverConfig.setWebDriver(new EdgeDriver());
            }
        }
    }
}
