package com.zebrunner.carina.demo.swag.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsPageBase extends AbstractPage {

    // Add any required locators for elements on the Products page here
    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    public ProductsPageBase(WebDriver driver) {
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

    public void logout() {
    }

    public void sortProductsByName() {
        List<String> productNamesList = new ArrayList<>();
        for (WebElement product : productNames) {
            productNamesList.add(product.getText());
        }

        Collections.sort(productNamesList, Comparator.naturalOrder());

        for (int i = 0; i < productNamesList.size(); i++) {
            productNames.get(i).getText().equals(productNamesList.get(i));
        }
    }


    public String getProductAtIndex(int index) {
        if (index >= 0 && index < productNames.size()) {
            return productNames.get(index).getText();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
    }
}