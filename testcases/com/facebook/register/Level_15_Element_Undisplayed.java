package com.facebook.register;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_15_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clicktoCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextBoxDisplayed());
		loginPage.enterToEmailAddressTextBox("automationFC@gmail.com");
		verifyTrue(loginPage.isConfirmEmailTextBoxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailAddressTextBox("");
		loginPage.sleepInSecond(1);
		verifyFalse(loginPage.isConfirmEmailTextBoxDisplayed());
		verifyTrue(loginPage.isConfirmEmailTextBoxUndisplayed());

	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToIconCloseRegisterForm();
		loginPage.sleepInSecond(1);
		verifyTrue(loginPage.isConfirmEmailTextBoxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
