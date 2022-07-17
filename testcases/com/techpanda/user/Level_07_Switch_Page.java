package com.techpanda.user;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.AccountInfoPageObject;
import pageObjects.user.navigations.sideBar.BillingAgreementsPageObject;
import pageObjects.user.navigations.sideBar.MyDownloadableProductsPageObject;
import pageObjects.user.navigations.sideBar.MyOrdersPageObject;
import pageObjects.user.navigations.sideBar.MyWishlistPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_07_Switch_Page extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserRegisterPageObject registerPage;
    AccountInfoPageObject myAccountinforPage;
    MyWishlistPageObject myWishlistPage;
    MyOrdersPageObject myOrdersPage;
    BillingAgreementsPageObject billingAgreementsPage;
    MyDownloadableProductsPageObject myDownloadableProductsPage;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void Login_06_Valid_Email_And_Password() {
        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
        loginPage.inputToPasswordTextbox("123456789");

        myDashboardPage = loginPage.clickToLoginButton();
        assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));
    }

    @Test
    public void Login_07_Update_Account_Information() {
        myAccountinforPage = myDashboardPage.getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

        myAccountinforPage.enterToFirstNameTextBox("WebDriver" + getRandomNumber());
        myAccountinforPage.enterToLastNameTextBox("Testing" + getRandomNumber());
        myAccountinforPage.enterToEmailAddressTextBox("automationfullstack@gmail.net");

        myAccountinforPage.enterToPasswordTextBox("123456789");
        myDashboardPage = myAccountinforPage.clickToSaveButton();

        Assert.assertTrue(myDashboardPage.isAccountInformationMessageSavedDisplayed());

    }

    @Test
    public void Switch_Page() {
        myAccountinforPage = myDashboardPage.getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

        myWishlistPage = myAccountinforPage.getSideBarMyAccountPage(driver).clickToMyWishlistLink();

        myOrdersPage = myWishlistPage.getSideBarMyAccountPage(driver).clickToMyOrdersLink();

        billingAgreementsPage = myOrdersPage.getSideBarMyAccountPage(driver).clickToBillingAgreementsLink();

        myDownloadableProductsPage = billingAgreementsPage.getSideBarMyAccountPage(driver)
                .clickToMyDownloadableProductsLink();

        myAccountinforPage = myDownloadableProductsPage.getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

        myDashboardPage = myAccountinforPage.getSideBarMyAccountPage(driver).clickToMyDashboardLink();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
