package com.sample.tests;

import com.sample.pages.CheckboxPage;
import com.sample.pages.DatePickerPage;
import com.sample.utils.WaitConfig;
import com.sample.utils.WaitUtils;
import com.sample.utils.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected CheckboxPage checkboxPage;
    protected DatePickerPage datePickerPage;

    public BaseTest() {
        checkboxPage = new CheckboxPage();
        datePickerPage = new DatePickerPage();
    }

    @BeforeEach
    void setUp() {
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
}
