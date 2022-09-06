package com.techpanda.user;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminManageCustomerPageObject;
import pageObjects.navigation.HeaderContainerPageObject;
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

public class Level_11_Global_Constants extends BaseTest {
	String userURL = GlobalConstants.LIVE_USER_URL;
	String adminURL = GlobalConstants.LIVE_ADMIN_URL;

	@Parameters({ "browser", "envName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, @Optional("local") String envName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(browserName, userURL, envName, osName, osVersion);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Switch_Role() {
		userLoginPage = userHomePage.getFooterContainerPage(driver).openLoginPage();
		userLoginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		userLoginPage.inputToPasswordTextbox("123456789");

		userMyDashboardPage = userLoginPage.clickToLoginButton();
		assertTrue(userMyDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

		// Logout
		userLoginPage.getHeaderContainerPage(driver).clickToUserLogoutButton();

		// User -> Admin
		adminLoginPage = userHomePage.openAdminLoginPage(driver, adminURL);

		adminLoginPage.inputUserNameTextBox(GlobalConstants.ADMIN_USERNAME);
		adminLoginPage.inputUserPasswordTextBox(GlobalConstants.ADMIN_PASSWORD);
		manageCustomerPage = adminLoginPage.clickToLoginButton();
		manageCustomerPage.closeIncomingMessagePopup();

		adminLoginPage = manageCustomerPage.clickToAdminLogoutLink();

		// Admin -> User
		userHomePage = adminLoginPage.openUserHomePage(driver, userURL);

		userLoginPage = userHomePage.getFooterContainerPage(driver).openLoginPage();
		userLoginPage.inputToEmailAddressTextbox("automationfullstack@gmail.net");
		userLoginPage.inputToPasswordTextbox("123456789");

		userMyDashboardPage = userLoginPage.clickToLoginButton();
		assertTrue(userMyDashboardPage.getUserInfoText().contains("automationfullstack@gmail.net"));

	}

	// User
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserMyDashboardPageObject userMyDashboardPage;
	UserRegisterPageObject userRegisterPage;

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
	HeaderContainerPageObject headerContainerPage;

	// Admin
	AdminLoginPageObject adminLoginPage;
	AdminManageCustomerPageObject manageCustomerPage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
