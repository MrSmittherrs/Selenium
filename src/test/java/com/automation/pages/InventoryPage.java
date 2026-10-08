package com.automation.pages;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {

    // Locators
    private By inventoryItem = By.cssSelector("[data-test='inventory-item']");
    private By itemName = By.cssSelector("[data-test='inventory-item-name']");
    private By itemButton = By.tagName("button");
    private By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Page Actions
    public void addToCart(String productName) {
        findItem(productName).findElement(itemButton).click();
    }

    public void removeFromCart(String productName) {
        findItem(productName).findElement(itemButton).click();
    }

    public void openCart() {
        click(cartLink);
    }

    // The badge sits inside the cart link, so the link's text is the count ("" when empty)
    public int getCartCount() {
        String count = text(cartLink).trim();
        return count.isEmpty() ? 0 : Integer.parseInt(count);
    }

    // Finds the product row whose name matches, so we can click the button in that row
    private WebElement findItem(String productName) {
        WaitUtils.visible(driver, inventoryItem);
        for (WebElement item : driver.findElements(inventoryItem)) {
            if (item.findElement(itemName).getText().equals(productName)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Product not found on inventory page: " + productName);
    }
}
