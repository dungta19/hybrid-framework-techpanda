package com.techpanda.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Common_01_Register_Cookie extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserRegisterPageObject registerPage;
	public static String userEmail, userPassword;
	public static String firstName, lastName;
	public static Set<Cookie> loggedCookies;

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
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
