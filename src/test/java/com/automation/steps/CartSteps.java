package com.automation.steps;

import com.automation.hooks.Hooks;
import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {

    @Given("I have added {string} to the cart")
    public void iHaveAddedToTheCart(String productName) {
        new InventoryPage(Hooks.getDriver()).addToCart(productName);
    }

    @When("I add {string} to the cart")
    public void iAddToTheCart(String productName) {
        new InventoryPage(Hooks.getDriver()).addToCart(productName);
    }

    @When("I remove {string} from the cart")
    public void iRemoveFromTheCart(String productName) {
        new InventoryPage(Hooks.getDriver()).removeFromCart(productName);
    }

    @When("I open the cart")
    public void iOpenTheCart() {
        new InventoryPage(Hooks.getDriver()).openCart();
    }

    @Then("the cart badge should show {int}")
    public void theCartBadgeShouldShow(int expectedCount) {
        int actualCount = new InventoryPage(Hooks.getDriver()).getCartCount();
        Assert.assertEquals(actualCount, expectedCount, "Cart badge count");
    }

    @Then("the cart badge should not be shown")
    public void theCartBadgeShouldNotBeShown() {
        int actualCount = new InventoryPage(Hooks.getDriver()).getCartCount();
        Assert.assertEquals(actualCount, 0, "Cart badge count");
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String productName) {
        Assert.assertTrue(new CartPage(Hooks.getDriver()).getItemNames().contains(productName),
                "Expected cart to contain: " + productName);
    }
}
