package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.navigations.footer.AboutUsPageObject;
import pageObjects.user.navigations.footer.AdvancedSearchPageObject;
import pageObjects.user.navigations.footer.ContactUsPageObject;
import pageObjects.user.navigations.footer.CustomerServicePageObject;
import pageObjects.user.navigations.footer.MyAccountPageObject;
import pageObjects.user.navigations.footer.OrderAndReturnsPageObject;
import pageObjects.user.navigations.footer.PrivacyPolicyPageObject;
import pageObjects.user.navigations.footer.SearchTermsPageObject;
import pageObjects.user.navigations.footer.SiteMapPageObject;
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

    public UserLoginPageObject openLoginPage() {
        waitForElementClickable(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
        clickToElement(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserLoginPage(driver);
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

    public OrderAndReturnsPageObject openOrderAndReturnsPage() {
        waitForElementClickable(driver, FooterContainerPageUIs.ORDERS_RETURNS_LINK);
        clickToElement(driver, FooterContainerPageUIs.ORDERS_RETURNS_LINK);
        return PageGeneratorManager.getOrderAndReturnsPage(driver);
    }

    /**
     * Open any pages in Footer Menu by using page name and dynamic locator method
     *
     * @param pageName
     */
    public void openFooterLinkByPageName(String pageName) {
        waitForElementClickable(driver, FooterContainerPageUIs.DYNAMIC_SIDE_BAR_LINK, pageName);
        clickToElement(driver, FooterContainerPageUIs.DYNAMIC_SIDE_BAR_LINK, pageName);
    }

    public FooterContainerPageObject openFooterLinkByPageNames(String pageName) {
        waitForElementClickable(driver, FooterContainerPageUIs.DYNAMIC_SIDE_BAR_LINK, pageName);
        clickToElement(driver, FooterContainerPageUIs.DYNAMIC_SIDE_BAR_LINK, pageName);

        if (pageName.equals("About Us")) {
            return PageGeneratorManager.getAboutUsPage(driver);
        } else if (pageName.equals("Contact Us")) {
            return PageGeneratorManager.getContactUsPage(driver);
        } else if (pageName.equals("Customer Service")) {
            return PageGeneratorManager.getCustomerServicePage(driver);
        } else if (pageName.equals("Privacy Policy")) {
            return PageGeneratorManager.getPrivacyPolicyPage(driver);
        } else if (pageName.equals("Search Terms")) {
            return PageGeneratorManager.getSearchTermsPage(driver);
        } else if (pageName.equals("Advanced Search")) {
            return PageGeneratorManager.getAdvancedSearchPage(driver);
        } else if (pageName.equals("My Account")) {
            return PageGeneratorManager.getMyAccountPage(driver);
        } else if (pageName.equals("Orders and Returns")) {
            return PageGeneratorManager.getOrderAndReturnsPage(driver);
        } else if (pageName.equals("Site Map")) {
            return PageGeneratorManager.getSiteMapPage(driver);
        } else {
            return null;
        }

    }

}
