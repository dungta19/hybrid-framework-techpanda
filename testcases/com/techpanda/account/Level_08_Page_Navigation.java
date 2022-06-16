package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.CreateAccountPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyDashboardPageObject;
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

public class Level_08_Page_Navigation extends BaseTest {
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
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void SideBarContainer_Page_Navigator() {
		loginPage = getFooterContainerPage(driver).openLoginPage();
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		loginPage.inputToPasswordTextbox("123456789");

		myDashboardPage = loginPage.clickToLoginButton();
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

		myAccountinforPage = getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myWishlistPage = getSideBarMyAccountPage(driver).clickToMyWishlistLink();

		myOrdersPage = getSideBarMyAccountPage(driver).clickToMyOrdersLink();

		billingAgreementsPage = getSideBarMyAccountPage(driver).clickToBillingAgreementsLink();

		myDownloadableProductsPage = getSideBarMyAccountPage(driver).clickToMyDownloadableProductsLink();

		myAccountinforPage = getSideBarMyAccountPage(driver).clickToMyAccountInfoLink();

		myDashboardPage = getSideBarMyAccountPage(driver).clickToMyDashboardLink();
	}

	@Test
	public void FooterContainer_Page_Navigator() {
		aboutUsPage = getFooterContainerPage(driver).openAboutUsPage();

		contactUsPage = getFooterContainerPage(driver).openContactUsPage();

		customerServicePage = getFooterContainerPage(driver).openCustomerServicePage();

		privacyPolicyPage = getFooterContainerPage(driver).openPrivacyPolicyPage();

		siteMapPage = getFooterContainerPage(driver).openSiteMapPage();

		searchTermsPage = getFooterContainerPage(driver).openSearchTermsPage();

		advancedSearchPage = getFooterContainerPage(driver).openAdvancedSearchPage();

		myAccountPage = getFooterContainerPage(driver).openMyAccountPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
