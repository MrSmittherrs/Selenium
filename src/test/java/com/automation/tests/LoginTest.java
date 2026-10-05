package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "securepassword");
    }
}
