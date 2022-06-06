package pageObjects;

import org.openqa.selenium.WebDriver;

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

	public static MyAddressBookPageObject getMyAddressBookPage(WebDriver driver) {
		return new MyAddressBookPageObject(driver);
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

}
