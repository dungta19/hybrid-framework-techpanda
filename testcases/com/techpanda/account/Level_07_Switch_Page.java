package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserCreateAccountPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyDashboardPageObject;
import pageObjects.user.sideBar.AccountInfoPageObject;
import pageObjects.user.sideBar.BillingAgreementsPageObject;
import pageObjects.user.sideBar.MyDownloadableProductsPageObject;
import pageObjects.user.sideBar.MyOrdersPageObject;
import pageObjects.user.sideBar.MyWishlistPageObject;

public class Level_07_Switch_Page extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserCreateAccountPageObject registerPage;
	AccountInfoPageObject myAccountinforPage;
	MyWishlistPageObject myWishlistPage;
	MyOrdersPageObject myOrdersPage;
	BillingAgreementsPageObject billingAgreementsPage;
	MyDownloadableProductsPageObject myDownloadableProductsPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		loginPage.inputToPasswordTextbox("123456789");

		myDashboardPage = loginPage.clickToLoginButton();
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));
//		myDashboardPage.clickToLogoutButton();
	}

	@Test
	public void Login_07_Update_Account_Information() {
		myAccountinforPage = getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myAccountinforPage.enterToFirstNameTextBox("WebDriver" + getRandomNumber());
		myAccountinforPage.enterToLastNameTextBox("Testing" + getRandomNumber());
		myAccountinforPage.enterToEmailAddressTextBox("automationfullstack@gmail.net");

		myAccountinforPage.enterToPasswordTextBox("123456789");
		myDashboardPage = myAccountinforPage.clickToSaveButton();

		Assert.assertTrue(myDashboardPage.isAccountInformationMessageSavedDisplayed());

	}

	@Test
	public void Switch_Page() {
		myAccountinforPage = getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myWishlistPage = getSideBarMyAccountPage(driver).clickToMyWishlistLink();

		myOrdersPage = getSideBarMyAccountPage(driver).clickToMyOrdersLink();

		billingAgreementsPage = getSideBarMyAccountPage(driver).clickToBillingAgreementsLink();

		myDownloadableProductsPage = getSideBarMyAccountPage(driver).clickToMyDownloadableProductsLink();

		myAccountinforPage = getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myDashboardPage = getSideBarMyAccountPage(driver).clickToMyDashboardLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
