package com.zebrunner.carina.demo.swag.desktop;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends AbstractPage {

    private By checkoutLabelLocator = By.xpath("//div[@class='checkout-label']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


}
