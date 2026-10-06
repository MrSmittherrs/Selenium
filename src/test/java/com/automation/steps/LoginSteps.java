package com.automation.steps;

import com.automation.hooks.Hooks;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        Hooks.getDriver().get(Hooks.getProperty("url"));
    }

    @When("I log in with username {string} and password {string}")
    public void iLogInWith(String username, String password) {
        new LoginPage(Hooks.getDriver()).login(username, password);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        String currentUrl = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"),
                "Expected to land on inventory page but was: " + currentUrl);
    }
}