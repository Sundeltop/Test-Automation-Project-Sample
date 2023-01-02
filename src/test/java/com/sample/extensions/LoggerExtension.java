package com.sample.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggerExtension implements BeforeEachCallback, AfterEachCallback {

    private static final Logger logger = LogManager.getLogger(LoggerExtension.class);

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        logger.info("Test {} is starting", extensionContext.getRequiredTestMethod().getName());
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        String methodName = extensionContext.getRequiredTestMethod().getName();
        extensionContext.getExecutionException().ifPresentOrElse(
                exception -> logger.warn("Test {} is failed {}",
                        methodName, exception.getMessage()),
                () -> logger.info("Test {} is passed", methodName));
    }
}
