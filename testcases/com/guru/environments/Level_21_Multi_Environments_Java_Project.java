package com.guru.environments;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;
import ultilities.DataHelper;

public class Level_21_Multi_Environments_Java_Project extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void Login_01_Empty_Email_Password() {
	}

	@Test
	public void Login_02_Invalid_Email() {
	}

	@Test(description = "Email not exist in application")
	public void Login_03_Incorrect_Email() {
	}

	@Test(description = "Password less than 6 characters")
	public void Login_04_Invalid_Password() {
	}

	@Test
	public void Login_05_Incorrect_Password() {
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
