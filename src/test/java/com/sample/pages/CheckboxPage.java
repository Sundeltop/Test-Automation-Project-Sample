package com.sample.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxPage extends BasePage {

    @FindBy(id = "checkbox-1")
    private WebElement firstCheckbox;

    public CheckboxPage() {
        super();
    }

    public CheckboxPage open() {
        openUrl("https://formy-project.herokuapp.com/checkbox");
        return this;
    }

    @Step("User clicks first checkbox")
    public CheckboxPage clickFirstCheckbox() {
        firstCheckbox.click();
        return this;
    }

    @Step("First checkbox is selected")
    public void isFirstCheckboxSelected() {
        assertTrue(firstCheckbox.isSelected());
    }

    @Step("First checkbox is not selected")
    public void isFirstCheckboxNotSelected() {
        assertFalse(firstCheckbox.isSelected());
    }
}
