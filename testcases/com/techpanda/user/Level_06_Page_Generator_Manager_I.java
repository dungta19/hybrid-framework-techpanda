package com.techpanda.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
		homePage = new UserHomePageObject(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.openLoginPage();
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void Login_03_Incorrect_Email() {
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void Login_04_Invalid_Password() {
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(randomNumber() + "");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboardPage = new UserMyDashboardPageObject(driver);
		assertTrue(myDashboardPage.getUserInfoText().contains("Automation FC"));
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfc.vn@gmail.com"));
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
