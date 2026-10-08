package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    // Runs once, the first time ConfigReader is used
    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    // An environment variable wins over the file, e.g. PASSWORD overrides password,
    // IMPLICIT_WAIT overrides implicit.wait
    public static String get(String key) {
        String envValue = System.getenv(key.toUpperCase().replace('.', '_'));
        return envValue != null ? envValue : prop.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}
