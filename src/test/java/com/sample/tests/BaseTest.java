package com.sample.tests;

import com.sample.extensions.LoggerExtension;
import com.sample.extensions.ScreenshotExtension;
import com.sample.pages.BasePage;
import com.sample.utils.WaitConfig;
import com.sample.utils.WaitUtils;
import com.sample.utils.WebDriverConfig;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

@ExtendWith({ScreenshotExtension.class, LoggerExtension.class})
public class BaseTest {

    @BeforeAll
    static void setSystemProperties() {
        System.setProperty("video.folder", "target/videos/");
    }

    @BeforeEach
    void setUp() {
        WebDriverConfig.initWebDriver();
        WaitUtils.setWaitConfiguration(WaitConfig.builder()
                .defaultImplicitTimeUnit(TimeUnit.SECONDS)
                .defaultExplicitTimeout(5)
                .defaultImplicitTimeout(5)
                .build());
    }

    @AfterEach
    void tearDown() {
        WebDriverConfig.clearCookies();
        WebDriverConfig.closeBrowser();
    }

    @SneakyThrows
    protected <T extends BasePage> T getPage(Class<T> cls) {
        return cls.getDeclaredConstructor().newInstance();
    }
}
