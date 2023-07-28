package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.swag.desktop.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;


public class SwagWebTesting implements IAbstractTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(getDriver());
        productsPage = new ProductsPage(getDriver());
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void LoginAndLogout() {
        loginPage.open();
        SoftAssert softAssert = new SoftAssert();

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();

        softAssert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        productsPage.logout();
        softAssert.assertTrue(loginPage.isPageOpened(), "Login page is not opened after logout.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void CartValidation() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");

        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Product 'Sauce Labs Backpack' is not in the cart.");
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"), "Product 'Sauce Labs Bike Light' is not in the cart.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void ProductCard() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        productsPage.clickProduct("Sauce Labs Backpack");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        Assert.assertTrue(productDetailsPage.isPageOpened(), "Product details page is not opened.");
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void Sorting() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        productsPage.sortProductsByName();
        Assert.assertEquals(productsPage.getProductAtIndex(0), "Sauce Labs Backpack", "First product is not as expected.");
        Assert.assertEquals(productsPage.getProductAtIndex(1), "Sauce Labs Bike Light", "Second product is not as expected.");
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void OpeningAllPages() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");
        productsPage.open();
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.open();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not opened.");
    }
}

