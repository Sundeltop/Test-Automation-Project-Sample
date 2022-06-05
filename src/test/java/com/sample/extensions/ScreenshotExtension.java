package com.sample.extensions;

import com.sample.utils.WebDriverStorage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;
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

    private void captureScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) WebDriverStorage.getWebDriver();
        try {
            FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),
                    new File(String.format("target/screenshots/screenshot-%s.png", fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
