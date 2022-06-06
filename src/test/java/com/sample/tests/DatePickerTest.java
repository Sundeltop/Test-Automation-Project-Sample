package com.sample.tests;

import com.sample.annotations.Browser;
import com.sample.annotations.Wait;
import com.sample.pages.DatePickerPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.sample.enums.BrowserType.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DatePickerTest extends BaseTest {

    @Test
    @Browser(browser = EDGE)
    @Wait(timeUnit = SECONDS, implicit = 5, explicit = 5)
    public void checkSelectDateRemovesDatePicker() {
        getPage(DatePickerPage.class)
                .selectDateFromCalendar(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .isDatePickerNotVisible();
    }
}
