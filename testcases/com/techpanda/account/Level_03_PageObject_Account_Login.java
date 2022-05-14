package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyDashboardPageObject;

public class Level_03_PageObject_Account_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	CreateAccountPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
		homePage = new HomePageObject(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.clickToMyAccountLink();
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void Login_03_Incorrect_Email() {
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void Login_04_Invalid_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(randomNumber() + "");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboardPage = new MyDashboardPageObject(driver);
		assertTrue(myDashboardPage.getUserInfoText().contains("Automation FC"));
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfc.vn@gmail.com"));
		myDashboardPage.clickToLogoutButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
