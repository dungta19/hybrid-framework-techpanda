package com.techpanda.account;

import commons.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserCreateAccountPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sideBar.UserMyDashboardPageObject;

public class Level_16_Allure extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserCreateAccountPageObject registerPage;
    String incorrectEmail = "auto_test" + getRandomNumber() + "@live.com";
    String invalidEmail = "123@456.789";
    String randomPassword = getRandomNumber() + "";

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Description("verify validate message with empty email and password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Login_01_Empty_Email_Password() {
        loginPage = homePage.openLoginPage();

        loginPage.inputToEmailAddressTextbox("");

        loginPage.inputToPasswordTextbox("");

        loginPage.clickToLoginButton();

        // Fail - 1
        Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field...");

        Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
    }

    @Description("verify validate message with invalid email")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Login_02_Invalid_Email() {

        loginPage.inputToEmailAddressTextbox(invalidEmail);

        loginPage.inputToPasswordTextbox("123456");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
                "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Description("verify validate message with an inccorect email")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Email not exist in application")
    public void Login_03_Incorrect_Email() {
        loginPage.inputToEmailAddressTextbox(incorrectEmail);

        loginPage.inputToPasswordTextbox("123456");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
    }

    @Description("verify validate message with unacceptable password")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Password less than 6 characters")
    public void Login_04_Invalid_Password() {
        loginPage.inputToEmailAddressTextbox(incorrectEmail);

        loginPage.inputToPasswordTextbox("123");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(),
                "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Description("verify validate message with an incorrect password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Login_05_Incorrect_Password() {
        loginPage.inputToEmailAddressTextbox(incorrectEmail);

        loginPage.inputToPasswordTextbox(randomPassword);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
    }

    @Description("Login to system with valid email and password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void Login_06_Valid_Email_And_Password() {
        loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");

        loginPage.inputToPasswordTextbox("123456789");

        myDashboardPage = loginPage.clickToLoginButton();

        // Fail - 1
        Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automation fullstackk"));

        Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

        myDashboardPage.getHeaderContainerPage(driver).clickToUserLogoutButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
