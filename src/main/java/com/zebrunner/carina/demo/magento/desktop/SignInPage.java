package com.zebrunner.carina.demo.magento.desktop;

import com.zebrunner.carina.demo.magento.common.SignInPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends SignInPageBase {
    @FindBy(id = "email")
    private WebElement usernameInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(className ="message-error error message")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInvalidCredentialsErrorDisplayed() {
        return !driver.findElements(By.cssSelector(".message-error error message span")).isEmpty();
    }

}
