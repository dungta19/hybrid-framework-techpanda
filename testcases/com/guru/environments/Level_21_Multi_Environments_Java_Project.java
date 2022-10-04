package com.guru.environments;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_21_Multi_Environments_Java_Project extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url", "envName", "ipAddress", "portNumber", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion, String ipAddress, String portNumber) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion, ipAddress, portNumber);
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
