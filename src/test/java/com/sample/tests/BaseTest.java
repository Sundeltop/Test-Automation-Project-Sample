package com.sample.tests;

import com.sample.annotations.Browser;
import com.sample.annotations.Log;
import com.sample.pages.BasePage;
import com.sample.utils.WaitConfig;
import com.sample.utils.WaitUtils;
import com.sample.utils.WebDriverStorage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.sample.enums.BrowserType.CHROME;

@Browser(browser = CHROME)
@Log
public class BaseTest {

    @BeforeAll
    static void setUp() {
        WaitUtils.setWaitConfiguration(WaitConfig.builder()
                .defaultImplicitTimeUnit(TimeUnit.SECONDS)
                .defaultExplicitTimeout(5)
                .defaultImplicitTimeout(5)
                .build());
        System.setProperty("video.folder", "target/videos/");
    }

    @AfterEach
    void tearDown() {
        WebDriverStorage.clearCookies();
        WebDriverStorage.closeBrowser();
    }

    @SneakyThrows
    protected <T extends BasePage> T getPage(Class<T> clazz) {
        return PageFactory.initElements(WebDriverStorage.getWebDriver(), clazz);
    }
}
