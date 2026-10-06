package com.automation.hooks;

// Cucumber's hook annotations. Make sure these are io.cucumber.java,
// NOT org.junit or org.testng, or the hooks silently never run.
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    // static = one shared copy for the whole run, not one per object.
    // Cucumber creates new Hooks/Steps objects per scenario, so a normal
    // field wouldn't be visible to the step classes.
    private static WebDriver driver;
    private static Properties prop;

    // Runs before EVERY scenario (like test.beforeEach)
    @Before
    public void setUp() throws IOException {
        // Load config.properties (browser, url, implicit.wait)
        prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/config.properties"));

        // Launch the browser named in config
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        int implicitWait = Integer.parseInt(prop.getProperty("implicit.wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    // Runs after EVERY scenario, even if it failed (like test.afterEach)
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Step classes call Hooks.getDriver() to get the browser
    // (this is how they get the equivalent of Playwright's `page`)
    public static WebDriver getDriver() {
        return driver;
    }

    // Step classes call Hooks.getProperty("url") to read config
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}