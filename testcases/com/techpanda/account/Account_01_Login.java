package com.techpanda.account;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.UserCreateAccountPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sideBar.UserMyDashboardPageObject;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Login extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserCreateAccountPageObject createAccountPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("123434@1234.456");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Login_03_Invalid_Password() {
		homePage.openLoginPage();

		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automation@gmail.com");
		loginPage.inputToPasswordTextbox("1234");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_04_Incorrect_Email_Password() {
		homePage.openLoginPage();

		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automation@gmail.com");
		loginPage.inputToPasswordTextbox("1234asdv");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Create_New_Account() {
		homePage.openLoginPage();

		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToCreateAccountButton();

		createAccountPage = new UserCreateAccountPageObject(driver);
		createAccountPage.inputToFirstNameTextbox("Automation");
		createAccountPage.inputToMiddleNameTextbox("S");
		createAccountPage.inputToLastNameTextbox("T");
		createAccountPage.inputToEmailAddressTextbox("automationST" + getRandomNumber() + "@gmail.com");
		createAccountPage.inputToPasswordTextbox("123456");
		createAccountPage.inputToPasswordConfirmTextbox("123456");
		createAccountPage.clickToRegisterButton();

		myDashboardPage = new UserMyDashboardPageObject(driver);
		Assert.assertEquals(myDashboardPage.getSuccessRegisterMessage(),
				"Thank you for registering with Main Website Store.");
		getHeaderContainerPage(driver).clickToUserLogoutButton();
	}

	@Test
	public void Login_05_Correct_Email_Password() {
		homePage.openLoginPage();

		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automationfullstack1234324@gmail.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		myDashboardPage = new UserMyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack"));
		getHeaderContainerPage(driver).clickToUserLogoutButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
