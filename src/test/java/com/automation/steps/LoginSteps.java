package com.automation.steps;

import com.automation.hooks.Hooks;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage()
    {
        Hooks.getDriver().get(ConfigReader.get("url"));
    }

    @Given("I am logged in as {string}")
    public void iAmLoggedInAs(String username)
    {
        Hooks.getDriver().get(ConfigReader.get("url"));
        new LoginPage(Hooks.getDriver()).login(username, ConfigReader.get("password"));
    }

    @When("I log in with username {string} and password {string}")
    public void iLogInWith(String username, String password)
    {
        new LoginPage(Hooks.getDriver()).login(username, password);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn()
    {
        Assert.assertTrue(WaitUtils.urlContains(Hooks.getDriver(), "inventory"),
                "Expected to land on inventory page but was: " + Hooks.getDriver().getCurrentUrl());
    }

    @Then("I should see the error {string}")
    public void iShouldSeeTheError(String expectedError) {
        String actualError = new LoginPage(Hooks.getDriver()).getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Login error message");
    }
}
