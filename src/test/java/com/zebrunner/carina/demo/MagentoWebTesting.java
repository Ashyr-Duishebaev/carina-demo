package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.magento.desktop.SignInPage;
import com.zebrunner.carina.demo.magento.desktop.ProductsPage;
import com.zebrunner.carina.demo.swag.desktop.CartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MagentoWebTesting implements IAbstractTest {
    private SignInPage signInPage;
    private ProductsPage productsPage;


    @BeforeMethod
    public void setup() {
        signInPage = new SignInPage(getDriver());
        productsPage = new ProductsPage(getDriver());
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void SignInTest() {
        signInPage.open();
        SoftAssert softAssert = new SoftAssert();

        signInPage.enterUsername("tony@gmail.com");
        signInPage.enterPassword("Ironman1!");
        signInPage.clickLoginButton();

        softAssert.assertTrue(signInPage.isPageOpened(), "Login page is not opened after logout.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void AddToCartAndValidate() {
        ProductsPage productsPage = new ProductsPage(getDriver());

        productsPage.open();
        productsPage.clickProductLink();
        productsPage.clickAddToCartButton();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.isProductInCart("Sybil Running Short"), "Product 'Sybil Running Short' is not in the cart.");
        softAssert.assertAll();
    }

}
