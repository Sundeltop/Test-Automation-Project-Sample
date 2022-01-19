package com.sample.pages;

import com.sample.utils.WebDriverConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected final WebDriver driver;

    public BasePage() {
        this.driver = WebDriverConfig.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @Step("User opens {0}")
    public void openUrl(String URL) {
        driver.get(URL);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
