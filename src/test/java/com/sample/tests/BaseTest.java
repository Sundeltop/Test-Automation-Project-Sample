package com.sample.tests;

import com.sample.extensions.SetupExtension;
import com.sample.extensions.LoggerExtension;
import com.sample.pages.BasePage;
import com.sample.utils.WebDriverStorage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.PageFactory;

@ExtendWith({LoggerExtension.class, SetupExtension.class})
public class BaseTest {

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
