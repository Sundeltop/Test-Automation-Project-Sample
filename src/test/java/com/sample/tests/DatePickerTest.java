package com.sample.tests;

import com.sample.annotations.Browser;
import com.sample.annotations.Evidence;
import com.sample.pages.DatePickerPage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerTest extends BaseTest {

    @Test
    @Evidence
    @Browser(browser = Browser.BrowserType.chrome)
    public void checkSelectDateRemovesDatePicker() {
        getPage(DatePickerPage.class)
                .open()
                .selectDate(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .isDatePickerNotVisible();
    }
}
