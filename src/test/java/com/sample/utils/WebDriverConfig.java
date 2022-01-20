package com.sample.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverConfig {

    private static final ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    private WebDriverConfig() throws IllegalAccessException {
        throw new IllegalAccessException("Can not create object of this class");
    }

    public static WebDriver getWebDriver() {
        return driverInstance.get();
    }

    public static void setWebDriver(WebDriver driver) {
        driverInstance.set(driver);
    }

    public static void closeBrowser() {
        driverInstance.get().quit();
        driverInstance.set(null);
    }

    public static void clearCookies() {
        driverInstance.get().manage().deleteAllCookies();
    }

}
