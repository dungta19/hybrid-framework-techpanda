package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AccountInfoPageObject;
import pageObjects.BillingAgreementsPageObject;
import pageObjects.CreateAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyDashboardPageObject;
import pageObjects.MyDownloadableProductsPageObject;
import pageObjects.MyOrdersPageObject;
import pageObjects.MyWishlistPageObject;
import pageObjects.PageGeneratorManager;

public class Level_07_Switch_Page extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	CreateAccountPageObject registerPage;
	AccountInfoPageObject myAccountinforPage;
	MyWishlistPageObject myWishlistPage;
	MyOrdersPageObject myOrdersPage;
	BillingAgreementsPageObject billingAgreementsPage;
	MyDownloadableProductsPageObject myDownloadableProductsPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		loginPage.inputToPasswordTextbox("123456789");

		myDashboardPage = loginPage.clickToLoginButton();
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));
//		myDashboardPage.clickToLogoutButton();
	}

	@Test
	public void Login_07_Update_Account_Information() {
		myAccountinforPage = myDashboardPage.clickToMyAccountInfoLink(driver);

		myAccountinforPage.enterToFirstNameTextBox("WebDriver" + getRandomNumber());
		myAccountinforPage.enterToLastNameTextBox("Testing" + getRandomNumber());
		myAccountinforPage.enterToEmailAddressTextBox("automationfullstack@gmail.net");

		myAccountinforPage.enterToPasswordTextBox("123456789");
		myDashboardPage = myAccountinforPage.clickToSaveButton();

		Assert.assertTrue(myDashboardPage.isAccountInformationMessageSavedDisplayed());

	}

	@Test
	public void Page_Navigator() {
		myAccountinforPage = myDashboardPage.clickToMyAccountInfoLink(driver);

		myWishlistPage = myAccountinforPage.clickToMyWishlistLink(driver);

		myOrdersPage = myWishlistPage.clickToMyOrdersLink(driver);

		billingAgreementsPage = myOrdersPage.clickToBillingAgreementsLink(driver);

		myDownloadableProductsPage = billingAgreementsPage.clickToMyDownloadableProductsLink(driver);

		myAccountinforPage = myDownloadableProductsPage.clickToMyAccountInfoLink(driver);

		myDashboardPage = myAccountinforPage.clickToMyDashboardLink(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
