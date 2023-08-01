package com.zebrunner.carina.demo.swag.desktop;

import com.zebrunner.carina.demo.swag.common.CartPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CartPageBase {

    private By removeButtonLocator = By.xpath("//button[@title='Remove']");
    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String productName) {
        for (WebElement cartItem : cartItems) {
            if (cartItem.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProductFromCart(String productName) {
        // Find the remove button for the specified product and click it
        WebElement removeButton = driver.findElement(By.xpath("//h2[text()='" + productName + "']/following::button[@title='Remove'][1]"));
        removeButton.click();
    }
}