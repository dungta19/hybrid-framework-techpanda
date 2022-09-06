package com.guru.environments;

import commons.BaseTest;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Environment;

public class Level_21_Multi_Environments_External_Library extends BaseTest {
	WebDriver driver;
	Environment environment;

	@Parameters({ "browser", "url", "envName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		ConfigFactory.setProperty("env", url);
		environment = ConfigFactory.create(Environment.class);
		System.out.println(environment.getAppUrl());

		driver = getBrowserDriver(browserName, environment.getAppUrl(), envName, osName, osVersion);

		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void Login_01_Empty_Email_Password() {
	}

	@Test
	public void Login_02_Invalid_Email() {
	}

	@Test
	public void Login_03_Incorrect_Email() {
	}

	@Test
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
