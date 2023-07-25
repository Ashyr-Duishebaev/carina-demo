package com.zebrunner.carina.demo.gui.pages.swag;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends AbstractPage {

    // Add any required locators for elements on the Checkout page here
    private By checkoutLabelLocator = By.xpath("//div[@class='checkout-label']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        // Implement the logic to check if the login page is opened correctly
        return isElementPresent(usernameFieldLocator) && isElementPresent(passwordFieldLocator)
                && isElementPresent(loginButtonLocator);
    }
}
