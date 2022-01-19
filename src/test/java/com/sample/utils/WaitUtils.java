package com.sample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class WaitUtils {

    private static WaitConfig config;

    private WaitUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Can not create object of this class");
    }

    public static void setWaitConfiguration(WaitConfig config) {
        WaitUtils.config = config;
    }

    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(config.getDefaultImplicitTimeout(), config.getDefaultImplicitTimeUnit());
    }

    public static void waitForPageLoad(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(config.getDefaultExplicitTimeout(), config.getDefaultImplicitTimeUnit());
    }

    public static void waitForJavaScriptReady(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, config.getDefaultExplicitTimeout());
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == \"complete\""));
    }

    public static <T> void explicitWait(WebDriver driver, Function<? super WebDriver, T> condition) {
        WebDriverWait wait = new WebDriverWait(driver, config.getDefaultExplicitTimeout());
        wait.until(condition);
    }
}
