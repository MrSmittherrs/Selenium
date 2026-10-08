package com.automation.pages;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    // Locators
    private By cartList = By.cssSelector("[data-test='cart-list']");
    private By itemName = By.cssSelector("[data-test='inventory-item-name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemNames() {
        // Wait for the cart page to render before reading its items
        WaitUtils.visible(driver, cartList);
        List<String> names = new ArrayList<>();
        for (WebElement name : driver.findElements(itemName)) {
            names.add(name.getText());
        }
        return names;
    }
}
