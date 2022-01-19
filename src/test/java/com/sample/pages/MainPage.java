package com.sample.pages;

import com.sample.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(css = "h1")
    private WebElement mainPageHeader;

    public MainPage() {
        super();
    }

    @Step("Get page header text")
    public String getMainPageHeaderText() {
        WaitUtils.explicitWait(getDriver(), ExpectedConditions.visibilityOf(mainPageHeader));
        return mainPageHeader.getText();
    }
}
