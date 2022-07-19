package com.techpanda.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

import java.util.Set;

public class Common_01_Register_Cookie extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserRegisterPageObject registerPage;
    public static String userEmail, userPassword;
    public static String firstName, lastName;
    public static Set<Cookie> loggedCookies;


    @Parameters({"browser"})
    @BeforeTest
    public void Login_01_Valid_Email_And_Password(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Tom";
        lastName = "Mulock";
        userEmail = "auto_test" + getRandomNumber() + "@live.com";
        userPassword = "123456";

        log.info("Pre-condition - Step 01 : Click to My Account link to navigate to Login Page");
        loginPage = homePage.openLoginPage();

        log.info("Pre-condition - Step 02 : Click to CREATE AN ACCOUNT button to navigate to Register Page");
        registerPage = loginPage.openRegisterPage();

        log.info("Pre-condition - Step 03 : Input to first name textbox with value is " + firstName);
        registerPage.inputToFirstNameTextbox(firstName);

        log.info("Pre-condition - Step 04 : Input to last name textbox with value is " + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        log.info("Pre-condition - Step 05 : Input to email address textbox with value is " + userEmail);
        registerPage.inputToEmailAddressTextbox(userEmail);

        log.info("Pre-condition - Step 06 : Input to password textbox with value is " + userPassword);
        registerPage.inputToPasswordTextbox(userPassword);

        log.info("Pre-condition - Step 07 : Input to confirm password textbox with value is " + userPassword);
        registerPage.inputToPasswordConfirmTextbox(userPassword);

        log.info("Pre-condition - Step 08 : click to Register button and navigate to My Dashboard Page");
        myDashboardPage = registerPage.clickToRegisterButton();

        log.info("Pre-condition - Step 09 : Verify whether the account is successfully registered");
        verifyTrue(myDashboardPage.getSuccessRegisterMessage().contains("Thank you for registering with Main Website Store."));

        log.info("Pre-condition - Step 10 : Verify whether the user email is correct as expected");
        verifyTrue(myDashboardPage.getUserInfoText().contains(firstName + " " + lastName));

        loggedCookies = myDashboardPage.getAllCookies(driver);

        driver.quit();
    }

//    @AfterTest
//    public void afterClass() {
//        driver.quit();
//    }

}
