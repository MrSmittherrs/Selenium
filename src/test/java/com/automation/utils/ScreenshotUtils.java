package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    // Attaches a screenshot to the Cucumber report when a scenario fails
    public static void attachIfFailed(WebDriver driver, Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(png, "image/png", scenario.getName());
        }
    }
}
