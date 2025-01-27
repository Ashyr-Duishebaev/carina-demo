package com.zebrunner.carina.demo.swag.desktop;

import com.zebrunner.carina.demo.swag.common.ProductDetailsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(className = "inventory_details_name")
    private WebElement productNameLabel;

    @FindBy(className = "inventory_details_price")
    private WebElement productPriceLabel;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productNameLabel.getText();
    }

    public String getProductPrice() {
        return productPriceLabel.getText();
    }
}