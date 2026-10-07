package com.automation.hooks;

// Cucumber's hook annotations. Make sure these are io.cucumber.java,
// NOT org.junit or org.testng, or the hooks silently never run.
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverFactory;
import com.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    // static = one shared copy for the whole run, not one per object.
    // Cucumber creates new Hooks/Steps objects per scenario, so a normal
    // field wouldn't be visible to the step classes.
    private static WebDriver driver;

    // Runs before EVERY scenario (like test.beforeEach)
    @Before
    public void setUp() {
        driver = DriverFactory.create(ConfigReader.get("browser"), ConfigReader.getBoolean("headless"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicit.wait")));
    }

    // Runs after EVERY scenario, even if it failed (like test.afterEach)
    @After
    public void tearDown(Scenario scenario) {
        ScreenshotUtils.attachIfFailed(driver, scenario);
        if (driver != null) {
            driver.quit();
        }
    }

    // Step classes call Hooks.getDriver() to get the browser
    // (this is how they get the equivalent of Playwright's `page`)
    public static WebDriver getDriver() {
        return driver;
    }
}
