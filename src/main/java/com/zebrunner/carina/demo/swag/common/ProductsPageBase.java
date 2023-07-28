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

    // Add ProductsPageBase-specific functionalities and methods here

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
        // Implement the logic to perform the logout action
        // For example, click on the logout button or navigate to the logout functionality
    }

    public void sortProductsByName() {
        // Implement the logic to sort the products by name (A to Z)
        // Use a custom comparator to sort the product names
        List<String> productNamesList = new ArrayList<>();
        for (WebElement product : productNames) {
            productNamesList.add(product.getText());
        }

        Collections.sort(productNamesList, Comparator.naturalOrder());

        // Update the productNames list with the sorted order
        for (int i = 0; i < productNamesList.size(); i++) {
            productNames.get(i).getText().equals(productNamesList.get(i));
        }
    }


    public String getProductAtIndex(int index) {
        // Get the product name at the given index
        if (index >= 0 && index < productNames.size()) {
            return productNames.get(index).getText();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
    }
}