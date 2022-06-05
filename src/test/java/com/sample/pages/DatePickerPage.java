package com.sample.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.sample.enums.Pages.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatePickerPage extends BasePage {

    @FindBy(id = "datepicker")
    private WebElement dateInput;

    @FindBy(className = "datepicker")
    private List<WebElement> datePicker;

    public DatePickerPage() {
        super();
    }

    @Override
    protected String getURL() {
        return DATE_PICKER_PAGE.getValue();
    }

    @Step("User selects {0} date from calendar")
    public DatePickerPage selectDateFromCalendar(String date) {
        dateInput.sendKeys(date, Keys.ENTER);
        return this;
    }

    @Step("Date picker is not visible")
    public void isDatePickerNotVisible() {
        assertEquals(0, datePicker.size());
    }
}
