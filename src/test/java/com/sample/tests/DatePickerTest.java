package com.sample.tests;

import com.sample.annotations.Browser;
import com.sample.annotations.Evidence;
import com.sample.enums.BrowserType;
import com.sample.pages.DatePickerPage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.sample.enums.BrowserType.*;

public class DatePickerTest extends BaseTest {

    @Test
    @Evidence
    @Browser(browser = EDGE)
    public void checkSelectDateRemovesDatePicker() {
        getPage(DatePickerPage.class)
                .selectDateFromCalendar(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .isDatePickerNotVisible();
    }
}
