package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_12_Data_Table_II extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Action() {
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(1);

		homePage.enterToTextBoxByHeaderNameAndRowNumber("Artist", "2", "Automation FC");
		homePage.sleepInSecond(1);

		homePage.enterToTextBoxByHeaderNameAndRowNumber("Price", "4", "360.1");
		homePage.sleepInSecond(1);

		homePage.enterToTextBoxByHeaderNameAndRowNumber("Album", "5", "Selenium Webdriver");
		homePage.sleepInSecond(1);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
