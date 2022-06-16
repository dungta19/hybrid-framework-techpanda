package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.LoginPageObject;
import pageObjects.user.footer.AboutUsPageObject;
import pageObjects.user.footer.AdvancedSearchPageObject;
import pageObjects.user.footer.ContactUsPageObject;
import pageObjects.user.footer.CustomerServicePageObject;
import pageObjects.user.footer.MyAccountPageObject;
import pageObjects.user.footer.PrivacyPolicyPageObject;
import pageObjects.user.footer.SearchTermsPageObject;
import pageObjects.user.footer.SiteMapPageObject;
import pageUIs.navigation.FooterContainerPageUIs;

public class FooterContainerPageObject extends BasePage {
	WebDriver driver;

	public FooterContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccountPageObject openMyAccountPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public LoginPageObject openLoginPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public AboutUsPageObject openAboutUsPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.ABOUT_US_LINK);
		clickToElement(driver, FooterContainerPageUIs.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}

	public ContactUsPageObject openContactUsPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.CONTACT_US_LINK);
		clickToElement(driver, FooterContainerPageUIs.CONTACT_US_LINK);
		return PageGeneratorManager.getContactUsPage(driver);
	}

	public CustomerServicePageObject openCustomerServicePage() {
		waitForElementClickable(driver, FooterContainerPageUIs.CUSTOMER_SERVICE_LINK);
		clickToElement(driver, FooterContainerPageUIs.CUSTOMER_SERVICE_LINK);
		return PageGeneratorManager.getCustomerServicePage(driver);
	}

	public PrivacyPolicyPageObject openPrivacyPolicyPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.PRIVACY_POLICY_LINK);
		clickToElement(driver, FooterContainerPageUIs.PRIVACY_POLICY_LINK);
		return PageGeneratorManager.getPrivacyPolicyPage(driver);
	}

	public SiteMapPageObject openSiteMapPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.SITE_MAP_LINK);
		clickToElement(driver, FooterContainerPageUIs.SITE_MAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);
	}

	public SearchTermsPageObject openSearchTermsPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.SEARCH_TERMS_LINK);
		clickToElement(driver, FooterContainerPageUIs.SEARCH_TERMS_LINK);
		return PageGeneratorManager.getSearchTermsPage(driver);
	}

	public AdvancedSearchPageObject openAdvancedSearchPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.ADVANCED_SEARCH_LINK);
		clickToElement(driver, FooterContainerPageUIs.ADVANCED_SEARCH_LINK);
		return PageGeneratorManager.getAdvancedSearchPage(driver);
	}

}
