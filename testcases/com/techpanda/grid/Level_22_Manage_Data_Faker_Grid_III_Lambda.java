package com.techpanda.grid;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;
import ultilities.DataHelper;

public class Level_22_Manage_Data_Faker_Grid_III_Lambda extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	DataHelper dataTesting;
	String incorrectEmail;
	String invalidEmail;
	String randomPassword;

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataTesting = DataHelper.getDataHelper();

		incorrectEmail = dataTesting.getEmailAddress();
		invalidEmail = "123@456.789";
		randomPassword = dataTesting.getPassword();
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		loginPage = homePage.openLoginPage();
		log.info("Login_01 - Step 1: Input an empty value to email address textbox ");
		loginPage.inputToTextBoxByID(driver, "email", "");

		log.info("Login_01 - Step 2: Input an empty value to password textbox ");
		loginPage.inputToTextBoxByID(driver, "pass", "");

		log.info("Login_01 - Step 3: Click to login button ");
		loginPage.clickToLoginButton();

		log.info("Login_01 - Step 4: Verify whether the validate email error message is correct as expected ");
		Assert.assertEquals(loginPage.getValidationAdviceMessageByLabelName(driver, "Email Address"), "This is a required field.");

		log.info("Login_01 - Step 5: Verify whether the validate password error message is correct as expected ");
		Assert.assertEquals(loginPage.getValidationAdviceMessageByLabelName(driver, "Password"), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {

		log.info("Login_02 - Step 1: Input an invalid email address '" + invalidEmail + "'");
		loginPage.inputToTextBoxByID(driver, "email", invalidEmail);

		log.info("Login_02 - Step 2: Input a valid password");
		loginPage.inputToTextBoxByID(driver, "pass", "123456");

		log.info("Login_02 - Step 3: Click to login button");
		// Do NOT use Pattern Object for any specific functionals
		loginPage.clickToLoginButton();

		log.info("Login_02 - Step 4: Verify whether the validate email error message is correct as expected");
		Assert.assertEquals(loginPage.getValidationAdviceMessageByLabelName(driver, "Email Address"), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void Login_03_Incorrect_Email() {
		log.info("Login_03 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
		loginPage.inputToTextBoxByID(driver, "email", incorrectEmail);

		log.info("Login_03 - Step 2: Input a valid password");
		loginPage.inputToTextBoxByID(driver, "pass", "123456");

		// Do NOT use Pattern Object for any specific functionals
		log.info("Login_03 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_03 - Step 4: Verify whether the validate email/password error message is correct as expected");
		Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void Login_04_Invalid_Password() {
		log.info("Login_04 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
		loginPage.inputToTextBoxByID(driver, "email", incorrectEmail);

		log.info("Login_04 - Step 2: Input a password less than 6 characters");
		loginPage.inputToTextBoxByID(driver, "pass", "123");

		log.info("Login_04 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_04 - Step 4: Verify whether the validate password error message is correct as expected");
		Assert.assertEquals(loginPage.getValidationAdviceMessageByLabelName(driver, "Password"), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		log.info("Login_05 - Step 1: Input a never registered email address '" + incorrectEmail + "'");
		loginPage.inputToTextBoxByID(driver, "email", incorrectEmail);

		log.info("Login_05 - Step 2: Input a well-formated password but it was never used before '" + randomPassword + "'");
		loginPage.inputToTextBoxByID(driver, "pass", randomPassword);

		log.info("Login_05 - Step 3: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login_05 - Step 4: Verify whether the validate password error message is correct as expected");
		Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		log.info("Login_06 - Step 1: Input a valid email address");
		loginPage.inputToTextBoxByID(driver, "email", "automationfullstack@gmail.net");

		log.info("Login_06 - Step 2: Input a valid password");
		loginPage.inputToTextBoxByID(driver, "pass", "123456789");

		log.info("Login_06 - Step 3: Click to login button");
		myDashboardPage = loginPage.clickToLoginButton();

		log.info("Login_06 - Step 4: Verify whether the user name  is correct as expected");
		Assert.assertTrue(myDashboardPage.getUserInfoText().contains("WebDriver351940 Testing677152"));

		log.info("Login_06 - Step 5: Verify whether the user email is correct as expected");
		Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

		log.info("Login_06 - Step 6: Click to logout button");
		myDashboardPage.getHeaderContainerPage(driver).clickToUserLogoutButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
