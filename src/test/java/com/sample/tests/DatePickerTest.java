package com.sample.tests;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerTest extends BaseTest {

    @Test
    public void checkSelectDate() {
        datePickerPage
                .open()
                .selectDate(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .isDatePickerNotVisible();
    }
}
