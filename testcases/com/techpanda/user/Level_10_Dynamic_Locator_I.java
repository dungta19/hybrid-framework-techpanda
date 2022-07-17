package com.techpanda.user;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class Level_10_Dynamic_Locator_I extends BaseTest {
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

    @Parameters({"browser"})
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
        myDashboardPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Account Information");
        myAccountinforPage = PageGeneratorManager.getAccountInfoPage(driver);

        myAccountinforPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("My Wishlist");
        myWishlistPage = PageGeneratorManager.getMyWishlistPage(driver);

        myWishlistPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("My Orders");
        myOrdersPage = PageGeneratorManager.getMyOrdersPage(driver);

        myOrdersPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Billing Agreements");
        billingAgreementsPage = PageGeneratorManager.getBillingAgreementsPage(driver);

        billingAgreementsPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("My Downloadable Products");
        myDownloadableProductsPage = PageGeneratorManager.getMyDownloadableProductsPage(driver);

        myDownloadableProductsPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Account Information");
        myAccountinforPage = PageGeneratorManager.getAccountInfoPage(driver);

        myAccountinforPage.getSideBarMyAccountPage(driver).openSideBarLinkByPageName("Account Dashboard");
        myDashboardPage = PageGeneratorManager.getUserMyDashboardPage(driver);
    }

    @Test
    public void TC_03_FooterContainer_Page_Navigator() {
        myDashboardPage.getFooterContainerPage(driver).openFooterLinkByPageName("About Us");
        aboutUsPage = PageGeneratorManager.getAboutUsPage(driver);

        aboutUsPage.getFooterContainerPage(driver).openFooterLinkByPageName("Contact Us");
        contactUsPage = PageGeneratorManager.getContactUsPage(driver);

        contactUsPage.getFooterContainerPage(driver).openFooterLinkByPageName("Customer Service");
        customerServicePage = PageGeneratorManager.getCustomerServicePage(driver);

        customerServicePage.getFooterContainerPage(driver).openFooterLinkByPageName("Privacy Policy");
        privacyPolicyPage = PageGeneratorManager.getPrivacyPolicyPage(driver);

        privacyPolicyPage.getFooterContainerPage(driver).openFooterLinkByPageName("Site Map");
        siteMapPage = PageGeneratorManager.getSiteMapPage(driver);

        siteMapPage.getFooterContainerPage(driver).openFooterLinkByPageName("Search Terms");
        searchTermsPage = PageGeneratorManager.getSearchTermsPage(driver);

        searchTermsPage.getFooterContainerPage(driver).openFooterLinkByPageName("Advanced Search");
        advancedSearchPage = PageGeneratorManager.getAdvancedSearchPage(driver);

        advancedSearchPage.getFooterContainerPage(driver).openFooterLinkByPageName("My Account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
