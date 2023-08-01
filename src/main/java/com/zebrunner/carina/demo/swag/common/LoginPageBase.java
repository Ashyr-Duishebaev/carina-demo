package com.zebrunner.carina.demo.swag.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageBase extends AbstractPage {
    @FindBy(id = "user-name")
    protected WebElement usernameInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(id = "login-button")
    protected WebElement loginButton;

    public LoginPageBase(WebDriver driver) {
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

}
