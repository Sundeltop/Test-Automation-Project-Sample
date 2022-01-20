package com.sample.tests;

import com.sample.extensions.SetupExtension;
import com.sample.extensions.LoggerExtension;
import com.sample.pages.BasePage;
import com.sample.utils.WebDriverStorage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({LoggerExtension.class, SetupExtension.class})
public class BaseTest {

    @AfterEach
    void tearDown() {
        WebDriverStorage.clearCookies();
        WebDriverStorage.closeBrowser();
    }

    @SneakyThrows
    protected <T extends BasePage> T getPage(Class<T> cls) {
        return cls.getDeclaredConstructor().newInstance();
    }
}
