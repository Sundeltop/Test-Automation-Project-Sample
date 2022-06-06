package com.sample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class WaitUtils {

    private static final ThreadLocal<WaitConfig> config = new ThreadLocal<>();

    private WaitUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Can't create object of static class");
    }

    public static void setWaitConfiguration(WaitConfig config) {
        WaitUtils.config.set(config);
    }

    private static WaitConfig getConfig() {
        return config.get();
    }

    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(
                getConfig().getDefaultImplicitTimeout(), getConfig().getDefaultImplicitTimeUnit());
    }

    public static void waitForPageLoad(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(
                getConfig().getDefaultExplicitTimeout(), getConfig().getDefaultImplicitTimeUnit());
    }

    public static void waitForJavaScriptReady(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, getConfig().getDefaultExplicitTimeout());
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == \"complete\""));
    }

    public static <T> void explicitWait(WebDriver driver, Function<? super WebDriver, T> condition) {
        WebDriverWait wait = new WebDriverWait(driver, getConfig().getDefaultExplicitTimeout());
        wait.until(condition);
    }
}
