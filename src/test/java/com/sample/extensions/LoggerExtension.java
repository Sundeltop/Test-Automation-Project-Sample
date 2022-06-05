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
        logger.info("Test %s is starting".formatted(extensionContext.getRequiredTestMethod().getName()));
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        String logMessage = "Test %s is passed";
        if (extensionContext.getExecutionException().isPresent()) {
            logMessage = "Test %s is failed: " + extensionContext.getExecutionException().get().getCause().getMessage();
        }
        logger.info(logMessage.formatted(extensionContext.getRequiredTestMethod().getName()));
    }
}
