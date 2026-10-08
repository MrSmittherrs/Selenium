package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private By usernameField = By.cssSelector("[data-test='username']");
    private By passwordField = By.cssSelector("[data-test='password']");
    private By loginButton = By.cssSelector("[data-test='login-button']");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Page Actions
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return text(errorMessage);
    }
}
