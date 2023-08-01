package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.swag.desktop.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;

import java.util.List;


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
    public void loginAndLogout() {
        loginPage.open();
        SoftAssert softAssert = new SoftAssert();

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        User user = new User(username, password);

        loginPage.enterUsername(user.getUsername());
        loginPage.enterPassword(user.getPassword());

        loginPage.clickLoginButton();

        softAssert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");

        if (!productsPage.isPageOpened()) {
            softAssert.fail("Login was not successful. Invalid username or password.");
        }

        productsPage.logout();
        softAssert.assertTrue(loginPage.isPageOpened(), "Login page is not opened after logout.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void cartValidation() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");

        // Add items to the cart
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");

        // Check if items are added to the cart
        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Product 'Sauce Labs Backpack' is not in the cart.");
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"), "Product 'Sauce Labs Bike Light' is not in the cart.");

        // Remove items from the cart
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        cartPage.removeProductFromCart("Sauce Labs Bike Light");

        // Check if items are removed from the cart
        softAssert.assertFalse(cartPage.isProductInCart("Sauce Labs Backpack"), "Product 'Sauce Labs Backpack' is still in the cart after removal.");
        softAssert.assertFalse(cartPage.isProductInCart("Sauce Labs Bike Light"), "Product 'Sauce Labs Bike Light' is still in the cart after removal.");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void productCard() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        productsPage.clickProduct("Sauce Labs Backpack");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        Assert.assertTrue(productDetailsPage.isPageOpened(), "Product details page is not opened.");
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void sorting() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        productsPage.sortProductsByName();
        Assert.assertEquals(productsPage.getProductAtIndex(0), "Sauce Labs Backpack", "First product is not as expected.");
        Assert.assertEquals(productsPage.getProductAtIndex(1), "Sauce Labs Bike Light", "Second product is not as expected.");
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void openingAllPages() {
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login.");
        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");
        productsPage.open();
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.open();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not opened.");
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void searchFunctionalityTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        String searchKeyword = "shirt";
        homePage.enterSearchKeyword(searchKeyword);
        homePage.clickSearchButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isSearchResultsPageDisplayed(), "Search results page is not displayed.");

        List<String> searchResults = homePage.getSearchResults();
        softAssert.assertTrue(!searchResults.isEmpty(), "No search results found.");
        for (String result : searchResults) {
            softAssert.assertTrue(result.contains(searchKeyword), "Search result does not match the search keyword.");
        }

        softAssert.assertAll();
    }
}

