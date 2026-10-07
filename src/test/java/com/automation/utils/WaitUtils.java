package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public static WebElement visible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement clickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Returns false instead of throwing, so steps can assert with a helpful message
    public static boolean urlContains(WebDriver driver, String fragment) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains(fragment));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
