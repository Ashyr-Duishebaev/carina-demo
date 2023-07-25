package com.zebrunner.carina.demo.gui.pages.swag;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends AbstractPage {

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayed(String productName) {
        for (WebElement product : productNames) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void addToCart(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                addToCartButtons.get(i).click();
                break;
            }
        }
    }

    public void clickProduct(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                productNames.get(i).click();
                break;
            }
        }
    }

    public void logout() {
    }

    public void sortProductsByName() {
    }
}
