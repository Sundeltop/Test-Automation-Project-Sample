package com.sample.tests;

import com.sample.annotations.Browser;
import com.sample.annotations.Log;
import com.sample.annotations.Wait;
import com.sample.pages.BasePage;
import com.sample.utils.WebDriverStorage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.PageFactory;

import static com.sample.enums.BrowserType.CHROME;
import static java.util.concurrent.TimeUnit.SECONDS;

@Browser(browser = CHROME)
@Log
@Wait(timeUnit = SECONDS, implicit = 3, explicit = 3)
public class BaseTest {

    @BeforeAll
    static void setUp() {
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
