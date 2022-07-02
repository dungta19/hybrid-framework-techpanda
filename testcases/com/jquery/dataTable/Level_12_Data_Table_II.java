package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_12_Data_Table_II extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "URL2" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
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

	@Test
	public void TC_02_Modify_Icons() {

	}

	@Test
	public void TC_03_Paging() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
