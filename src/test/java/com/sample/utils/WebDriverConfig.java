package com.sample.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {

    private static WebDriver driverInstance;

    private WebDriverConfig() throws IllegalAccessException {
        throw new IllegalAccessException("Can not create object of this class");
    }

    public static WebDriver initWebDriver() {
        if (driverInstance != null) return driverInstance;
        return switch (PropertyReader.getBrowser()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driverInstance = new ChromeDriver();
                yield driverInstance;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driverInstance = new FirefoxDriver();
                yield driverInstance;
            }
            default -> {
                WebDriverManager.edgedriver().setup();
                driverInstance = new EdgeDriver();
                yield driverInstance;
            }
        };
    }

    public static WebDriver getWebDriver() {
        return driverInstance;
    }

    public static void closeBrowser() {
        driverInstance.quit();
        driverInstance = null;
    }

    public static void clearCookies() {
        driverInstance.manage().deleteAllCookies();
    }

}
