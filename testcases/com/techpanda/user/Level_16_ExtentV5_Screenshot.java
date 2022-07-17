package com.techpanda.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;
import reportConfig.ExtentTestManager;

public class Level_16_ExtentV5_Screenshot extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserRegisterPageObject registerPage;
    String incorrectEmail = "auto_test" + getRandomNumber() + "@live.com";
    String invalidEmail = "123@456.789";
    String randomPassword = getRandomNumber() + "";

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void Login_01_Empty_Email_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_01_Empty_Email_Password");
        loginPage = homePage.openLoginPage();
        ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 1: Input an empty value to email address textbox ");
        loginPage.inputToEmailAddressTextbox("");

        ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 2: Input an empty value to password textbox ");
        loginPage.inputToPasswordTextbox("");

        ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 3: Click to login button ");
        loginPage.clickToLoginButton();

        // Fail - 1
        ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 4: Verify whether the validate email error message is correct as expected ");
        Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field...");

        ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 5: Verify whether the validate password error message is correct as expected ");
        Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_02_Invalid_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Login_02 - Step 1: Input an invalid email address '" + invalidEmail + "'");
        loginPage.inputToEmailAddressTextbox(invalidEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Login_02 - Step 2: Input a valid password");
        loginPage.inputToPasswordTextbox("123456");

        ExtentTestManager.getTest().log(Status.INFO, "Login_02 - Step 3: Click to login button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login_02 - Step 4: Verify whether the validate email error message is correct as expected");
        Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test(description = "Email not exist in application")
    public void Login_03_Incorrect_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_03_Incorrect_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
        loginPage.inputToEmailAddressTextbox(incorrectEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 2: Input a valid password");
        loginPage.inputToPasswordTextbox("123456");

        ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 3: Click to login button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 4: Verify whether the validate email/password error message is correct as expected");
        Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");

    }

    @Test(description = "Password less than 6 characters")
    public void Login_04_Invalid_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_04_Invalid_Password");

        ExtentTestManager.getTest().log(Status.INFO, "Login_04 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
        loginPage.inputToEmailAddressTextbox(incorrectEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Login_04 - Step 2: Input a password less than 6 characters");
        loginPage.inputToPasswordTextbox("123");

        ExtentTestManager.getTest().log(Status.INFO, "Login_04 - Step 3: Click to login button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login_04 - Step 4: Verify whether the validate password error message is correct as expected");
        Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void Login_05_Incorrect_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_05_Incorrect_Password");

        ExtentTestManager.getTest().log(Status.INFO, "Login_05 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
        loginPage.inputToEmailAddressTextbox(incorrectEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Login_05 - Step 2: Input a well-formated password but it was never used before '" + randomPassword + "'");
        loginPage.inputToPasswordTextbox(randomPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Login_05 - Step 3: Click to login button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login_05 - Step 4: Verify whether the validate password error message is correct as expected");
        Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");

    }

    @Test
    public void Login_06_Valid_Email_And_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_06_Valid_Email_And_Password");

        ExtentTestManager.getTest().log(Status.INFO, "Login_06 - Step 1: Input a valid email address");
        loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");

        ExtentTestManager.getTest().log(Status.INFO, "Login_06 - Step 2: Input a valid password");
        loginPage.inputToPasswordTextbox("123456789");

        ExtentTestManager.getTest().log(Status.INFO, "Login_06 - Step 3: Click to login button");
        myDashboardPage = loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login_06 - Step 4: Verify whether the user name  is correct as expected");
        // Fail - 1
        Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automation fullstackk"));

        ExtentTestManager.getTest().log(Status.INFO, "Login_06 - Step 5: Verify whether the user email is correct as expected");
        Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

        ExtentTestManager.getTest().log(Status.INFO, "Login_06 - Step 6: Click to logout button");
        myDashboardPage.getHeaderContainerPage(driver).clickToUserLogoutButton();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
