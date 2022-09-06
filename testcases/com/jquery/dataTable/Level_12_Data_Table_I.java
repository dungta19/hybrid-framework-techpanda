package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_12_Data_Table_I extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url", "envName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Verify() {
		homePage.enterToTextBoxByHeaderName("Country", "Argentina");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isRowValuesDisplayed("338282", "Argentina", "349238", "687522"));
		homePage.refreshCurrentPage(driver);

		homePage.enterToTextBoxByHeaderName("Total", "687522");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isRowValuesDisplayed("338282", "Argentina", "349238", "687522"));
		homePage.refreshCurrentPage(driver);

		homePage.enterToTextBoxByHeaderName("Females", "338282");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isRowValuesDisplayed("338282", "Argentina", "349238", "687522"));
		homePage.refreshCurrentPage(driver);

	}

	@Test
	public void TC_02_Modify_Icons() {
		homePage.clickToModifyIconByCountryName("Afghanistan", "remove");
		homePage.sleepInSecond(1);

		homePage.clickToModifyIconByCountryName("Albania", "remove");
		homePage.sleepInSecond(1);

		homePage.clickToModifyIconByCountryName("Argentina", "remove");
		homePage.sleepInSecond(1);

		homePage.refreshCurrentPage(driver);

		homePage.clickToModifyIconByCountryName("Albania", "remove");
		homePage.sleepInSecond(1);

	}

	@Test
	public void TC_03_Paging() {
		homePage.clickToPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("10"));

		homePage.clickToPageNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("5"));

		homePage.clickToPageNumber("15");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("15"));

		homePage.clickToPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("20"));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
