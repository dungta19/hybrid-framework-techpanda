package com.techpanda.account;

import org.testng.annotations.Test;

import pageObjects.CreateAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyDashboardPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	CreateAccountPageObject createAccountPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("123434@1234.456");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Login_03_Invalid_Password() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automation@gmail.com");
		loginPage.inputToPasswordTextbox("1234");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_04_Incorrect_Email_Password() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automation@gmail.com");
		loginPage.inputToPasswordTextbox("1234asdv");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Create_New_Account() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToCreateAccountButton();

		createAccountPage = new CreateAccountPageObject(driver);
		createAccountPage.inputToFirstNameTextbox("Automation");
		createAccountPage.inputToMiddleNameTextbox("S");
		createAccountPage.inputToLastNameTextbox("T");
		createAccountPage.inputToEmailAddressTextbox("automationST" + getRandomNumber() + "@gmail.com");
		createAccountPage.inputToPasswordTextbox("123456");
		createAccountPage.inputToPasswordConfirmTextbox("123456");
		createAccountPage.clickToRegisterButton();

		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertEquals(myDashboardPage.getSuccessRegisterMessage(),
				"Thank you for registering with Main Website Store.");
		myDashboardPage.clickToLogoutButton();
	}

	@Test
	public void Login_05_Correct_Email_Password() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automationfullstack1234324@gmail.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack"));
		myDashboardPage.clickToLogoutButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
