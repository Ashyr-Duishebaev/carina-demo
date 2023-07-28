package com.zebrunner.carina.demo.magento.common;


import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPageBase extends AbstractPage {

    // Add any required locators for elements on the Cart page here
    private By cartItemLocator = By.className("cart_item");
    private By cartItemNameLocator = By.className("inventory_item_name");

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    // Add CartPageBase-specific functionalities and methods here

    public boolean isProductInCart(String productName) {
        for (WebElement cartItem : cartItems) {
            WebElement productNameElement = cartItem.findElement(cartItemNameLocator);
            if (productNameElement.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    // You can add additional methods or functionalities that are shared by CartPage and other related pages
}