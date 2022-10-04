package com.facebook.register;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_15_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
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
