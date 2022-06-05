package com.sample.pages;

import com.sample.utils.WebDriverStorage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private final WebDriver driver;

    public BasePage() {
        this.driver = WebDriverStorage.getWebDriver();
        openUrl(getURL());
    }

    protected abstract String getURL();

    @Step("User opens {0} URL")
    private void openUrl(String URL) {
        driver.get(URL);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
