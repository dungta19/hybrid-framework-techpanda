package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CreateAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyDashboardPageObject;

public class Level_06_Page_Generator_Manager_II extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	CreateAccountPageObject registerPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new HomePageObject(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage = homePage.clickToMyAccountLink();
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void Login_03_Incorrect_Email() {
		loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void Login_04_Invalid_Password() {
		loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(getRandomNumber() + "");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getEmailPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		myDashboardPage = loginPage.clickToLoginButton();

		assertTrue(myDashboardPage.getUserInfoText().contains("automationfc.vn@gmail.com"));
		myDashboardPage.clickToLogoutButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}