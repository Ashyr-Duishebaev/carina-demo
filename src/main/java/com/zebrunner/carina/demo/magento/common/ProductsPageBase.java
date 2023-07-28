package com.zebrunner.carina.demo.magento.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPageBase extends AbstractPage {
    @FindBy(css = ".product-item-link")
    protected WebElement productLink;

    @FindBy(css = "[data-role='tocart-form'] button")
    protected WebElement addToCartButton;

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public void clickProductLink() {
        productLink.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
