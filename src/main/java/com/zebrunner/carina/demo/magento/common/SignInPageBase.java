package com.zebrunner.carina.demo.magento.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageBase extends AbstractPage {
    @FindBy(id = "email")
    protected WebElement usernameInput;

    @FindBy(id = "pass")
    protected WebElement passwordInput;

    @FindBy(id = "send2")
    protected WebElement loginButton;

    public SignInPageBase(WebDriver driver) {
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
        driver.get("https://magento.softwaretestingboard.com");
    }

}
