package com.techpanda.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_17_Custom_Close_Browser extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserRegisterPageObject registerPage;
    private String userEmail, userPassword;
    private String firstName, lastName;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Tom";
        lastName = "Mulock";
        userEmail = "auto_test" + getRandomNumber() + "@live.com";
        userPassword = "123456";

        log.info("Pre-condition with Register - Step 01 : Click to My Account link to navigate to Login Page");
        loginPage = homePage.openLoginPage();

        log.info("Pre-condition with Register - Step 02 : Click to CREATE AN ACCOUNT button to navigate to Register Page");
        registerPage = loginPage.openRegisterPage();

        log.info("Pre-condition with Register - Step 03 : Input to first name textbox with value is " + firstName);
        registerPage.inputToFirstNameTextbox(firstName);

        log.info("Pre-condition with Register - Step 04 : Input to last name textbox with value is " + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        log.info("Pre-condition with Register - Step 05 : Input to email address textbox with value is " + userEmail);
        registerPage.inputToEmailAddressTextbox(userEmail);

        log.info("Pre-condition with Register - Step 06 : Input to password textbox with value is " + userPassword);
        registerPage.inputToPasswordTextbox(userPassword);

        log.info("Pre-condition with Register - Step 07 : Input to confirm password textbox with value is " + userPassword);
        registerPage.inputToPasswordConfirmTextbox(userPassword);

        log.info("Pre-condition with Register - Step 08 : click to Register button and navigate to My Dashboard Page");
        myDashboardPage = registerPage.clickToRegisterButton();

        log.info("Pre-condition with Register - Step 09 : Verify whether the account is successfully registered");
        verifyTrue(myDashboardPage.getSuccessRegisterMessage().contains("Thank you for registering with Main Website Store."));

        log.info("Pre-condition with Register - Step 09 : Log out and navigate to Login Page");
        homePage = myDashboardPage.getHeaderContainerPage(driver).clickToUserLogoutButton();

        log.info("Pre-condition with Login - Step 01 : Click to My Account link to navigate to Login Page");
        loginPage = homePage.openLoginPage();

        log.info("Pre-condition with Login - Step 1: Input a valid email address: '" + userEmail + "'");
        loginPage.inputToEmailAddressTextbox(userEmail);

        log.info("Pre-condition with Login - Step 2: Input a valid password: '" + userPassword + "'");
        loginPage.inputToPasswordTextbox(userPassword);

        log.info("Pre-condition with Login - Step 3: Click to login button");
        myDashboardPage = loginPage.clickToLoginButton();

        log.info("Pre-condition with Login - Step 4: Verify whether the user name  is correct as expected as '" + firstName + " " + lastName + "'");
        verifyTrue(myDashboardPage.getUserInfoText().contains(firstName + " " + lastName));

        log.info("Pre-condition with Login - Step 5: Verify whether the user email is correct as expected as '" + userEmail + "'");
        verifyTrue(myDashboardPage.getUserInfoText().contains(userEmail));

    }

    @Test
    public void Login_01() {

    }

    @Test
    public void Login_02() {

    }

    @Test
    public void Login_03() {

    }

    @Test
    public void Login_04() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
