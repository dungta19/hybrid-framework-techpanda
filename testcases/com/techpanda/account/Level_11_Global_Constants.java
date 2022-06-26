package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminManageCustomerPageObject;
import pageObjects.navigation.HeaderContainerPageObject;
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

public class Level_11_Global_Constants extends BaseTest {
	String userURL;
	String adminURL;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		this.userURL = GlobalConstants.LIVE_USER_URL;
		this.adminURL = GlobalConstants.LIVE_ADMIN_URL;

		driver = getBrowserDriver(browserName, userURL);
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
	UserCreateAccountPageObject userRegisterPage;

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
