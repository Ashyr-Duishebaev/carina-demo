package com.zebrunner.carina.demo.magento.desktop;

import com.zebrunner.carina.demo.magento.common.CartPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CartPageBase {

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

    public int getCartItemCount() {
        WebElement cartItemCountElement = driver.findElement(By.cssSelector(".minicart-wrapper .counter-number"));
        String itemCountText = cartItemCountElement.getText();
        return Integer.parseInt(itemCountText);
    }

}