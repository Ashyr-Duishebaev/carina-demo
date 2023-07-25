package com.zebrunner.carina.demo.gui.pages.swag;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public boolean isPageOpened() {
        // Implement the logic to check if the login page is opened correctly
        return isElementPresent(usernameFieldLocator) && isElementPresent(passwordFieldLocator)
                && isElementPresent(loginButtonLocator);
    }

}