package com.techpanda.user;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_14_Assert_Verify extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserRegisterPageObject registerPage;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = homePage.openLoginPage();
    }

    @Test
    public void Login_01_Empty_Email_Password() {
        loginPage.inputToEmailAddressTextbox("");
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();

        // Fail - 1
        verifyEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field...");
        verifyEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        loginPage.inputToEmailAddressTextbox("123@456.789");
        loginPage.inputToPasswordTextbox("123456");
        loginPage.clickToLoginButton();

        verifyEquals(loginPage.getEmailAddressInvalidErrorMessage(),
                "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Email not exist in application")
    public void Login_03_Incorrect_Email() {
        loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
        loginPage.inputToPasswordTextbox("123456");
        loginPage.clickToLoginButton();

        verifyEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void Login_04_Invalid_Password() {
        loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
        loginPage.inputToPasswordTextbox("123");
        loginPage.clickToLoginButton();

        verifyEquals(loginPage.getPasswordInvalidErrorMessage(),
                "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Login_05_Incorrect_Password() {
        loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
        loginPage.inputToPasswordTextbox(getRandomNumber() + "");
        loginPage.clickToLoginButton();
        verifyEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
    }

    @Test
    public void Login_06_Valid_Email_And_Password() {
        loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
        loginPage.inputToPasswordTextbox("123456789");

        myDashboardPage = loginPage.clickToLoginButton();

        // Fail - 1
        verifyTrue(myDashboardPage.getUserInfoText().contains("automation fullstackk"));
        verifyTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

        // Fail - 2
        verifyTrue(myDashboardPage.getUserInfoText().contains("automationfullstackKKKK@gmail.net"));
        myDashboardPage.getHeaderContainerPage(driver).clickToUserLogoutButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
