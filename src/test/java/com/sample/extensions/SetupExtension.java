package com.sample.extensions;

import com.sample.annotations.Browser;
import com.sample.utils.WaitConfig;
import com.sample.utils.WaitUtils;
import com.sample.utils.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SetupExtension implements BeforeAllCallback, BeforeEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        WaitUtils.setWaitConfiguration(WaitConfig.builder()
                .defaultImplicitTimeUnit(TimeUnit.SECONDS)
                .defaultExplicitTimeout(5)
                .defaultImplicitTimeout(5)
                .build());
        System.setProperty("video.folder", "target/videos/");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        if (Objects.isNull(extensionContext.getRequiredTestClass().getAnnotation(Browser.class))
                && Objects.isNull(extensionContext.getRequiredTestMethod().getAnnotation(Browser.class))) {
            WebDriverManager.chromedriver().setup();
            WebDriverConfig.setWebDriver(new ChromeDriver());
        }
    }
}
