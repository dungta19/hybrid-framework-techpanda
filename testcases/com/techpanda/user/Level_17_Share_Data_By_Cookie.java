package com.techpanda.user;

import com.techpanda.common.Common_01_Register_Cookie;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_17_Share_Data_By_Cookie extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url", "envName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login_01 - Step 01 : Click to My Account link to navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Login_01 - Step 2 : Login to Application by using cookie and open My Dashboard Page as successfully login");
		myDashboardPage = loginPage.loginToMyDashboardPageByCookie(Common_01_Register_Cookie.loggedCookies);

		log.info("Login_01 - Step 3: Verify whether the user name  is correct as expected as '" + Common_01_Register_Cookie.firstName + " " + Common_01_Register_Cookie.lastName + "'");
		verifyTrue(myDashboardPage.getUserInfoText().contains(Common_01_Register_Cookie.firstName + " " + Common_01_Register_Cookie.lastName));

		log.info("Login_01 - Step 4: Verify whether the user email is correct as expected as '" + Common_01_Register_Cookie.userEmail + "'");
		verifyTrue(myDashboardPage.getUserInfoText().contains(Common_01_Register_Cookie.userEmail));

	}

	@Test
	public void Login_01() {

	}

	@Test
	public void Login_02() {

	}

	@Test
	public void Login_03() {

	}

	@Test
	public void Login_04() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
