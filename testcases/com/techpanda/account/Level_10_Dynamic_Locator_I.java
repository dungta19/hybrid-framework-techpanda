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

public class Level_10_Dynamic_Locator_I extends BaseTest {
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
		loginPage = getFooterContainerPage(driver).openLoginPage();
		loginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		loginPage.inputToPasswordTextbox("123456789");

		myDashboardPage = loginPage.clickToLoginButton();
		assertTrue(myDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));
	}

	@Test
	public void TC_02_SideBarContainer_Page_Navigator() {
		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Account Information");
		myAccountinforPage = PageGeneratorManager.getAccountInfoPage(driver);

		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("My Wishlist");
		myWishlistPage = PageGeneratorManager.getMyWishlistPage(driver);

		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("My Orders");
		myOrdersPage = PageGeneratorManager.getMyOrdersPage(driver);

		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Billing Agreements");
		billingAgreementsPage = PageGeneratorManager.getBillingAgreementsPage(driver);

		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("My Downloadable Products");
		myDownloadableProductsPage = PageGeneratorManager.getMyDownloadableProductsPage(driver);

		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Account Information");
		myAccountinforPage = PageGeneratorManager.getAccountInfoPage(driver);

		getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Account Dashboard");
		myDashboardPage = PageGeneratorManager.getUserMyDashboardPage(driver);
	}

	@Test
	public void TC_03_FooterContainer_Page_Navigator() {
		getFooterContainerPage(driver).openFooterLinkByPageName("About Us");
		aboutUsPage = PageGeneratorManager.getAboutUsPage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("Contact Us");
		contactUsPage = PageGeneratorManager.getContactUsPage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("Customer Service");
		customerServicePage = PageGeneratorManager.getCustomerServicePage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("Privacy Policy");
		privacyPolicyPage = PageGeneratorManager.getPrivacyPolicyPage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("Site Map");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("Search Terms");
		searchTermsPage = PageGeneratorManager.getSearchTermsPage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("Advanced Search");
		advancedSearchPage = PageGeneratorManager.getAdvancedSearchPage(driver);

		getFooterContainerPage(driver).openFooterLinkByPageName("My Account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}