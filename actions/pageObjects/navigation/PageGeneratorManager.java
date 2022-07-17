package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminManageCustomerPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.navigations.footer.AboutUsPageObject;
import pageObjects.user.navigations.footer.AdvancedSearchPageObject;
import pageObjects.user.navigations.footer.ContactUsPageObject;
import pageObjects.user.navigations.footer.CustomerServicePageObject;
import pageObjects.user.navigations.footer.MyAccountPageObject;
import pageObjects.user.navigations.footer.OrderAndReturnsPageObject;
import pageObjects.user.navigations.footer.PrivacyPolicyPageObject;
import pageObjects.user.navigations.footer.SearchTermsPageObject;
import pageObjects.user.navigations.footer.SiteMapPageObject;
import pageObjects.user.navigations.sideBar.AccountInfoPageObject;
import pageObjects.user.navigations.sideBar.BillingAgreementsPageObject;
import pageObjects.user.navigations.sideBar.AddressBookPageObject;
import pageObjects.user.navigations.sideBar.MyApplicationsPageObject;
import pageObjects.user.navigations.sideBar.MyDownloadableProductsPageObject;
import pageObjects.user.navigations.sideBar.MyOrdersPageObject;
import pageObjects.user.navigations.sideBar.MyProductReviewsPageObject;
import pageObjects.user.navigations.sideBar.MyWishlistPageObject;
import pageObjects.user.navigations.sideBar.NewsletterSubscriptionsPageObject;
import pageObjects.user.navigations.sideBar.RecurringProfilesPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserMyDashboardPageObject getUserMyDashboardPage(WebDriver driver) {
        return new UserMyDashboardPageObject(driver);
    }

    public static AccountInfoPageObject getAccountInfoPage(WebDriver driver) {
        return new AccountInfoPageObject(driver);
    }

    public static AddressBookPageObject getMyAddressBookPage(WebDriver driver) {
        return new AddressBookPageObject(driver);
    }

    public static MyOrdersPageObject getMyOrdersPage(WebDriver driver) {
        return new MyOrdersPageObject(driver);
    }

    public static BillingAgreementsPageObject getBillingAgreementsPage(WebDriver driver) {
        return new BillingAgreementsPageObject(driver);
    }

    public static RecurringProfilesPageObject getRecurringProfilesPage(WebDriver driver) {
        return new RecurringProfilesPageObject(driver);
    }

    public static MyProductReviewsPageObject getMyProdcutReviewsPage(WebDriver driver) {
        return new MyProductReviewsPageObject(driver);
    }

    public static MyWishlistPageObject getMyWishlistPage(WebDriver driver) {
        return new MyWishlistPageObject(driver);
    }

    public static MyApplicationsPageObject getMyApplicationsPage(WebDriver driver) {
        return new MyApplicationsPageObject(driver);
    }

    public static NewsletterSubscriptionsPageObject getNewsletterSubscriptionsPage(WebDriver driver) {
        return new NewsletterSubscriptionsPageObject(driver);
    }

    public static MyDownloadableProductsPageObject getMyDownloadableProductsPage(WebDriver driver) {
        return new MyDownloadableProductsPageObject(driver);
    }

    public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
        return new AboutUsPageObject(driver);
    }

    public static ContactUsPageObject getContactUsPage(WebDriver driver) {
        return new ContactUsPageObject(driver);
    }

    public static CustomerServicePageObject getCustomerServicePage(WebDriver driver) {
        return new CustomerServicePageObject(driver);
    }

    public static PrivacyPolicyPageObject getPrivacyPolicyPage(WebDriver driver) {
        return new PrivacyPolicyPageObject(driver);
    }

    public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
        return new SiteMapPageObject(driver);
    }

    public static SearchTermsPageObject getSearchTermsPage(WebDriver driver) {
        return new SearchTermsPageObject(driver);
    }

    public static AdvancedSearchPageObject getAdvancedSearchPage(WebDriver driver) {
        return new AdvancedSearchPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminManageCustomerPageObject getAdminManageCustomer(WebDriver driver) {
        return new AdminManageCustomerPageObject(driver);
    }

    public static OrderAndReturnsPageObject getOrderAndReturnsPage(WebDriver driver) {
        return new OrderAndReturnsPageObject(driver);
    }

    public static UserRegisterPageObject getRegisterPageObject(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }
}
