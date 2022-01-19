package com.sample.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    private static final String PROPERTIES_FILE_NAME = "config.properties";
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(Objects.requireNonNull(
                    PropertyReader.class.getClassLoader().getResource(PROPERTIES_FILE_NAME)).getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyReader() throws IllegalAccessException {
        throw new IllegalAccessException("Can not create object of this class");
    }

    private static String getProperty(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            throw new NoSuchElementException("No such property with key" + key);
        }
    }

    public static String getBrowser() {
        return getProperty("browser");
    }
}
