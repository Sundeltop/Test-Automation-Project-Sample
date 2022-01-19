package com.sample.tests;

import com.automation.remarks.junit5.Video;
import com.sample.pages.DatePickerPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify select date removes date picker")
    @Test
    @Video
    public void checkSelectDateRemovesDatePicker() {
        getPage(DatePickerPage.class)
                .open()
                .selectDate(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .isDatePickerNotVisible();
    }
}
