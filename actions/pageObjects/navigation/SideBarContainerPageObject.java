package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.UserMyDashboardPageObject;
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
import pageUIs.navigation.SideBarMyAccountPageUIs;

public class SideBarContainerPageObject extends BasePage {
	WebDriver driver;

	public SideBarContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Open Page link
	public UserMyDashboardPageObject clickToMyDashboardLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_DASHBOARD_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_DASHBOARD_LINK);
		return PageGeneratorManager.getUserMyDashboardPage(driver);
	}

	public AccountInfoPageObject clickToMyAccountInfoLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_ACCOUNT_INFO_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_ACCOUNT_INFO_LINK);
		return PageGeneratorManager.getAccountInfoPage(driver);
	}

	public AddressBookPageObject clickToMyAddressBookLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_ADDRESS_BOOK_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_ADDRESS_BOOK_LINK);
		return PageGeneratorManager.getMyAddressBookPage(driver);
	}

	public MyOrdersPageObject clickToMyOrdersLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_ORDERS_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_ORDERS_LINK);
		return PageGeneratorManager.getMyOrdersPage(driver);
	}

	public BillingAgreementsPageObject clickToBillingAgreementsLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.BILLING_AGREEMENTS_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.BILLING_AGREEMENTS_LINK);
		return PageGeneratorManager.getBillingAgreementsPage(driver);
	}

	public RecurringProfilesPageObject clickToRecurringProfilesLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.RECURRING_PROFILES_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.RECURRING_PROFILES_LINK);
		return PageGeneratorManager.getRecurringProfilesPage(driver);
	}

	public MyProductReviewsPageObject clickToyProductReviewsLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_PRODUCT_REVIEWS_LINK);
		return PageGeneratorManager.getMyProdcutReviewsPage(driver);
	}

	public MyWishlistPageObject clickToMyWishlistLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_WISHLIST_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_WISHLIST_LINK);
		return PageGeneratorManager.getMyWishlistPage(driver);
	}

	public MyApplicationsPageObject clickToMyApplicationsLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_APPLICATIONS_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_APPLICATIONS_LINK);
		return PageGeneratorManager.getMyApplicationsPage(driver);
	}

	public NewsletterSubscriptionsPageObject clickToNewsletterSubscriptionsLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.NEWSLETTER_SUBSCRIPTIONS_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.NEWSLETTER_SUBSCRIPTIONS_LINK);
		return PageGeneratorManager.getNewsletterSubscriptionsPage(driver);
	}

	public MyDownloadableProductsPageObject clickToMyDownloadableProductsLink() {
		waitForElementClickable(driver, SideBarMyAccountPageUIs.MY_DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, SideBarMyAccountPageUIs.MY_DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneratorManager.getMyDownloadableProductsPage(driver);
	}

}
