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

public class Level_10_Dynamic_Locator_II extends BaseTest {
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
	public void TC_01_Login() {
		loginPage = homePage.getFooterContainerPage(driver).openLoginPage();
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		loginPage.inputToPasswordTextbox("123456789");

		myDashboardPage = loginPage.clickToLoginButton();
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));
	}

	@Test
	public void TC_02_SideBarContainer_Page_Navigator() {
		myAccountinforPage = (AccountInfoPageObject) myDashboardPage.getSideBarMyAccountPage(driver)
				.openSideBarLinkByPageNames("Account Information");

		myWishlistPage = (MyWishlistPageObject) myAccountinforPage.getSideBarMyAccountPage(driver)
				.openSideBarLinkByPageNames("My Wishlist");

		myOrdersPage = (MyOrdersPageObject) myWishlistPage.getSideBarMyAccountPage(driver)
				.openSideBarLinkByPageNames("My Orders");

		billingAgreementsPage = (BillingAgreementsPageObject) myOrdersPage.getSideBarMyAccountPage(driver)
				.openSideBarLinkByPageNames("Billing Agreements");

		myDownloadableProductsPage = (MyDownloadableProductsPageObject) billingAgreementsPage
				.getSideBarMyAccountPage(driver).openSideBarLinkByPageNames("My Downloadable Products");

		myAccountinforPage = (AccountInfoPageObject) myDownloadableProductsPage.getSideBarMyAccountPage(driver)
				.openSideBarLinkByPageNames("Account Information");

		myDashboardPage = (UserMyDashboardPageObject) myAccountinforPage.getSideBarMyAccountPage(driver)
				.openSideBarLinkByPageNames("Account Dashboard");
	}

	@Test
	public void TC_03_FooterContainer_Page_Navigator() {
		aboutUsPage = (AboutUsPageObject) myDashboardPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("About Us");

		contactUsPage = (ContactUsPageObject) aboutUsPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("Contact Us");

		customerServicePage = (CustomerServicePageObject) contactUsPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("Customer Service");

		privacyPolicyPage = (PrivacyPolicyPageObject) customerServicePage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("Privacy Policy");

		siteMapPage = (SiteMapPageObject) privacyPolicyPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("Site Map");

		searchTermsPage = (SearchTermsPageObject) siteMapPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("Search Terms");

		advancedSearchPage = (AdvancedSearchPageObject) advancedSearchPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("Advanced Search");

		myAccountPage = (MyAccountPageObject) myAccountPage.getFooterContainerPage(driver)
				.openFooterLinkByPageNames("My Account");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
