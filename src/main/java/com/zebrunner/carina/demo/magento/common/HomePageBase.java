package com.zebrunner.carina.demo.magento.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePageBase extends AbstractPage {

    @FindBy(id = "search")
    protected WebElement searchInput;

    @FindBy(css = "button[title='Search']")
    protected WebElement searchButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public void enterSearchKeyword(String keyword) {
        type(searchInput, keyword);
    }

    private void type(WebElement searchInput, String keyword) {
    }

    public void clickSearchButton() {
        searchInput.click();
    }

    public boolean isSearchResultsPageDisplayed() {
        return false;
    }

    public List<String> getSearchResults() {
        return new ArrayList<>();
    }
}
