package com.sample.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.sample.enums.Pages.CHECKBOX_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxPage extends BasePage {

    @FindBy(id = "checkbox-1")
    private WebElement firstCheckbox;

    public CheckboxPage() {
        super();
    }

    @Override
    protected String getURL() {
        return CHECKBOX_PAGE.getValue();
    }

    @Step("User clicks first checkbox")
    public CheckboxPage clickFirstCheckbox() {
        firstCheckbox.click();
        return this;
    }

    @Step("First checkbox is selected")
    public void isFirstCheckboxSelected() {
        assertThat(firstCheckbox.isSelected()).isTrue();
    }

    @Step("First checkbox is not selected")
    public void isFirstCheckboxNotSelected() {
        assertThat(firstCheckbox.isSelected()).isFalse();
    }
}
