package com.saucelab.sort;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.SauceLabHomePageObject;
import pageObjects.saucelab.SauceLabLoginPageObject;

public class Level_20_Sort_Asc_Des extends BaseTest {
    WebDriver driver;
    SauceLabLoginPageObject saucelabUserLoginPage;
    SauceLabHomePageObject saucelabHomePage;
    private String userName, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        userName = "standard_user";
        password = "secret_sauce";
        saucelabUserLoginPage = PageGeneratorManager.getSauceLabLoginPage(driver);
        saucelabUserLoginPage.enterToUserNameTextBox(userName);
        saucelabUserLoginPage.enterToPasswordTextBox(password);
        saucelabUserLoginPage.clickToLoginButton();
        saucelabHomePage = PageGeneratorManager.getSauceLabHomePage(driver);
    }

    @Test
    public void Sort_01_Name_Asc() {
        saucelabHomePage.sortItemByText("Name (A to Z)");
        verifyTrue(saucelabHomePage.isProductNamesSortedAscending());
    }

    @Test
    public void Sort_02_Name_Des() {
        saucelabHomePage.sortItemByText("Name (Z to A)");
        verifyTrue(saucelabHomePage.isProductNamesSortedDescending());
    }

    @Test
    public void Sort_03_Price_Asc() {
        saucelabHomePage.sortItemByText("Price (low to high)");
        verifyTrue(saucelabHomePage.isProductPricesSortedAscending());
    }

    @Test
    public void Sort_04_Price_Des() {
        saucelabHomePage.sortItemByText("Price (high to low)");
        verifyTrue(saucelabHomePage.isProductPriceSortedDescending());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
