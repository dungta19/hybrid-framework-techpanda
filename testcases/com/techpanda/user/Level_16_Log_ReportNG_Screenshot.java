package com.techpanda.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_16_Log_ReportNG_Screenshot extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserRegisterPageObject registerPage;
	String incorrectEmail = "auto_test" + getRandomNumber() + "@live.com";
	String invalidEmail = "123@456.789";
	String randomPassword = getRandomNumber() + "";

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		loginPage = homePage.openLoginPage();
		log.info("Login_01 - Step 1: Input an empty value to email address textbox ");
		loginPage.inputToEmailAddressTextbox("");

		log.info("Login_01 - Step 2: Input an empty value to password textbox ");
		loginPage.inputToPasswordTextbox("");

		log.info("Login_01 - Step 3: Click to login button ");
		loginPage.clickToLoginButton();

		// Fail - 1
		log.info("Login_01 - Step 4: Verify whether the validate email error message is correct as expected ");
		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field...");

		log.info("Login_01 - Step 5: Verify whether the validate password error message is correct as expected ");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {

		log.info("Login_02 - Step 1: Input an invalid email address '" + invalidEmail + "'");
		loginPage.inputToEmailAddressTextbox(invalidEmail);

		log.info("Login_02 - Step 2: Input a valid password");
		loginPage.inputToPasswordTextbox("123456");

		log.info("Login_02 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_02 - Step 4: Verify whether the validate email error message is correct as expected");
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void Login_03_Incorrect_Email() {
		log.info("Login_03 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
		loginPage.inputToEmailAddressTextbox(incorrectEmail);

		log.info("Login_03 - Step 2: Input a valid password");
		loginPage.inputToPasswordTextbox("123456");

		log.info("Login_03 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_03 - Step 4: Verify whether the validate email/password error message is correct as expected");
		Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void Login_04_Invalid_Password() {
		log.info("Login_04 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
		loginPage.inputToEmailAddressTextbox(incorrectEmail);

		log.info("Login_04 - Step 2: Input a password less than 6 characters");
		loginPage.inputToPasswordTextbox("123");

		log.info("Login_04 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_04 - Step 4: Verify whether the validate password error message is correct as expected");
		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		log.info("Login_05 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
		loginPage.inputToEmailAddressTextbox(incorrectEmail);

		log.info("Login_05 - Step 2: Input a well-formated password but it was never used before '" + randomPassword + "'");
		loginPage.inputToPasswordTextbox(randomPassword);

		log.info("Login_05 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_05 - Step 4: Verify whether the validate password error message is correct as expected");
		Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		log.info("Login_06 - Step 1: Input a valid email address");
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");

		log.info("Login_06 - Step 2: Input a valid password");
		loginPage.inputToPasswordTextbox("123456789");

		log.info("Login_06 - Step 3: Click to login button");
		myDashboardPage = loginPage.clickToLoginButton();

		log.info("Login_06 - Step 4: Verify whether the user name  is correct as expected");
		// Fail - 1
		Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automation fullstackk"));

		log.info("Login_06 - Step 5: Verify whether the user email is correct as expected");
		Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

		log.info("Login_06 - Step 6: Click to logout button");
		myDashboardPage.getHeaderContainerPage(driver).clickToUserLogoutButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}