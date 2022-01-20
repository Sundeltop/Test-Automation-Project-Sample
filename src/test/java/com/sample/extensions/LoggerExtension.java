package com.sample.extensions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggerExtension implements BeforeEachCallback, AfterEachCallback {
    private final Logger logger = LogManager.getLogger(LoggerExtension.class);

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        logger.info(String.format("Test %s is starting", extensionContext.getRequiredTestMethod().getName()));
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        String logMessage;
        if (extensionContext.getExecutionException().isPresent()) {
            logMessage = "Test %s is failed: " + extensionContext.getExecutionException().get().getMessage();
        } else {
            logMessage = "Test %s is passed";
        }
        logger.info(String.format(logMessage, extensionContext.getRequiredTestMethod().getName()));
    }
}
