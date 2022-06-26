package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserCreateAccountPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.footer.AboutUsPageObject;
import pageObjects.user.footer.AdvancedSearchPageObject;
import pageObjects.user.footer.ContactUsPageObject;
import pageObjects.user.footer.CustomerServicePageObject;
import pageObjects.user.footer.MyAccountPageObject;
import pageObjects.user.footer.PrivacyPolicyPageObject;
import pageObjects.user.footer.SearchTermsPageObject;
import pageObjects.user.footer.SiteMapPageObject;
import pageObjects.user.sideBar.AccountInfoPageObject;
import pageObjects.user.sideBar.BillingAgreementsPageObject;
import pageObjects.user.sideBar.MyDownloadableProductsPageObject;
import pageObjects.user.sideBar.MyOrdersPageObject;
import pageObjects.user.sideBar.MyWishlistPageObject;
import pageObjects.user.sideBar.UserMyDashboardPageObject;

public class Level_08_Page_Navigation extends BaseTest {
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
	AboutUsPageObject aboutUsPage;
	ContactUsPageObject contactUsPage;
	CustomerServicePageObject customerServicePage;
	SiteMapPageObject siteMapPage;
	SearchTermsPageObject searchTermsPage;
	AdvancedSearchPageObject advancedSearchPage;
	PrivacyPolicyPageObject privacyPolicyPage;
	MyAccountPageObject myAccountPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_SideBarContainer_Page_Navigator() {
		loginPage = homePage.getFooterContainerPage(driver).openLoginPage();
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		loginPage.inputToPasswordTextbox("123456789");

		myDashboardPage = loginPage.clickToLoginButton();
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

		myAccountinforPage = myDashboardPage.getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myWishlistPage = myAccountinforPage.getSideBarMyAccountPage(driver).clickToMyWishlistLink();

		myOrdersPage = myWishlistPage.getSideBarMyAccountPage(driver).clickToMyOrdersLink();

		billingAgreementsPage = myOrdersPage.getSideBarMyAccountPage(driver).clickToBillingAgreementsLink();

		myDownloadableProductsPage = billingAgreementsPage.getSideBarMyAccountPage(driver)
				.clickToMyDownloadableProductsLink();

		myAccountinforPage = myDownloadableProductsPage.getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myDashboardPage = myAccountinforPage.getSideBarMyAccountPage(driver).clickToMyDashboardLink();
	}

	@Test
	public void TC_02_FooterContainer_Page_Navigator() {
		aboutUsPage = myDashboardPage.getFooterContainerPage(driver).openAboutUsPage();

		contactUsPage = aboutUsPage.getFooterContainerPage(driver).openContactUsPage();

		customerServicePage = contactUsPage.getFooterContainerPage(driver).openCustomerServicePage();

		privacyPolicyPage = customerServicePage.getFooterContainerPage(driver).openPrivacyPolicyPage();

		siteMapPage = privacyPolicyPage.getFooterContainerPage(driver).openSiteMapPage();

		searchTermsPage = siteMapPage.getFooterContainerPage(driver).openSearchTermsPage();

		advancedSearchPage = searchTermsPage.getFooterContainerPage(driver).openAdvancedSearchPage();

		myAccountPage = advancedSearchPage.getFooterContainerPage(driver).openMyAccountPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
