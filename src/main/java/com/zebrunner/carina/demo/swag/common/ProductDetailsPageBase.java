package com.zebrunner.carina.demo.swag.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageBase extends AbstractPage {

    // Add any required locators for elements on the Product Details page here
    // Example:
     @FindBy(xpath = "//div[@class='product-name']")
     private WebElement productName;

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    // Add ProductDetailsPageBase-specific functionalities and methods here
    // For example, you can add methods to get product details or perform specific actions on the product details page
}