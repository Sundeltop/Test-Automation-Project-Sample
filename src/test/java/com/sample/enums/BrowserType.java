package com.sample.enums;

import com.sample.utils.WebDriverStorage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.lang.reflect.InvocationTargetException;

public enum BrowserType {
    CHROME(ChromeDriver.class),
    OPERA(OperaDriver.class),
    FIREFOX(FirefoxDriver.class),
    EDGE(EdgeDriver.class);

    private final Class<? extends WebDriver> driver;

    BrowserType(Class<? extends WebDriver> driver) {
        this.driver = driver;
    }

    public void setup() {
        WebDriverManager.getInstance(driver).setup();
        try {
            WebDriverStorage.setWebDriver(driver.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
