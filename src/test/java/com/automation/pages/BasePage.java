package com.automation.pages;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Shared helpers for every page object. Each helper waits for the element first,
// so page objects never need Thread.sleep or raw findElement calls.
public abstract class BasePage {
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        WaitUtils.clickable(driver, locator).click();
    }

    protected void type(By locator, String text) {
        WaitUtils.visible(driver, locator).sendKeys(text);
    }

    protected String text(By locator) {
        return WaitUtils.visible(driver, locator).getText();
    }
}
