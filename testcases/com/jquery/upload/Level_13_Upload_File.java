package com.jquery.upload;

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

public class Level_13_Upload_File extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	String seleniumImage = "Selenium.jpeg";
	String appiumImage = "Appium.jpeg";
	String apiImage = "API.jpeg";

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Single_File() {
		homePage.uploadMultipleFiles(driver, seleniumImage);

		Assert.assertTrue(homePage.isFileUploadedByFileName(seleniumImage));

		homePage.clickToStartUploadButton();

		Assert.assertTrue(homePage.isFileUploadedSuccessful(seleniumImage));
	}

	@Test
	public void TC_02_Multi_Files() {
		homePage.refreshCurrentPage(driver);

		homePage.uploadMultipleFiles(driver, seleniumImage, appiumImage, apiImage);

		Assert.assertTrue(homePage.isFileUploadedByFileName(seleniumImage));
		Assert.assertTrue(homePage.isFileUploadedByFileName(appiumImage));
		Assert.assertTrue(homePage.isFileUploadedByFileName(apiImage));

		homePage.clickToStartUploadButton();

		Assert.assertTrue(homePage.isFileUploadedSuccessful(seleniumImage));
		Assert.assertTrue(homePage.isFileUploadedSuccessful(appiumImage));
		Assert.assertTrue(homePage.isFileUploadedSuccessful(apiImage));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
