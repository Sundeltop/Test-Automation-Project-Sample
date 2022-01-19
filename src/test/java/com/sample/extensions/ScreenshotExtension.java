package com.sample.extensions;

import com.sample.utils.WebDriverConfig;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        if (extensionContext.getExecutionException().isPresent()) {
            captureScreenshot(extensionContext.getRequiredTestMethod().getName());
        }
    }

    public void captureScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) WebDriverConfig.getWebDriver();
        try {
            FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File("target/screenshots/" + "screenshot-" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
