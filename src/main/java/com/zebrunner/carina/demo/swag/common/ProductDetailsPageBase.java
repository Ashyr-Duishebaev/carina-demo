package com.zebrunner.carina.demo.swag.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageBase extends AbstractPage {

     @FindBy(xpath = "//div[@class='product-name']")
     private WebElement productName;

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

}