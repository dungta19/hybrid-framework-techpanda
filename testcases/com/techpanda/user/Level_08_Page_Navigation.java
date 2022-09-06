package com.techpanda.user;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.footer.AboutUsPageObject;
import pageObjects.user.navigations.footer.AdvancedSearchPageObject;
import pageObjects.user.navigations.footer.ContactUsPageObject;
import pageObjects.user.navigations.footer.CustomerServicePageObject;
import pageObjects.user.navigations.footer.MyAccountPageObject;
import pageObjects.user.navigations.footer.PrivacyPolicyPageObject;
import pageObjects.user.navigations.footer.SearchTermsPageObject;
import pageObjects.user.navigations.footer.SiteMapPageObject;
import pageObjects.user.navigations.sideBar.AccountInfoPageObject;
import pageObjects.user.navigations.sideBar.BillingAgreementsPageObject;
import pageObjects.user.navigations.sideBar.MyDownloadableProductsPageObject;
import pageObjects.user.navigations.sideBar.MyOrdersPageObject;
import pageObjects.user.navigations.sideBar.MyWishlistPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_08_Page_Navigation extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	UserRegisterPageObject registerPage;
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

	@Parameters({ "browser", "url", "envName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String url, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(browserName, url, envName, osName, osVersion);
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

		myDownloadableProductsPage = billingAgreementsPage.getSideBarMyAccountPage(driver).clickToMyDownloadableProductsLink();

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
