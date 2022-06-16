package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

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
import pageObjects.user.sideBar.AddressBookPageObject;
import pageObjects.user.sideBar.MyApplicationsPageObject;
import pageObjects.user.sideBar.MyDownloadableProductsPageObject;
import pageObjects.user.sideBar.MyOrdersPageObject;
import pageObjects.user.sideBar.MyProductReviewsPageObject;
import pageObjects.user.sideBar.MyWishlistPageObject;
import pageObjects.user.sideBar.NewsletterSubscriptionsPageObject;
import pageObjects.user.sideBar.RecurringProfilesPageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
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

}
