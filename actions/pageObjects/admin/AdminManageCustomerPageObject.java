package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageUIs.admin.AdminManageCustomerPageUIs;

public class AdminManageCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closeIncomingMessagePopup() {
		waitForElementVisible(driver, AdminManageCustomerPageUIs.ADMIN_POPUP_MESSAGE);
		waitForElementClickable(driver, AdminManageCustomerPageUIs.ADMIN_POPUP_CLOSE_BUTTON);
		clickToElement(driver, AdminManageCustomerPageUIs.ADMIN_POPUP_CLOSE_BUTTON);
	}

	public AdminLoginPageObject clickToAdminLogoutLink() {
		waitForElementClickable(driver, AdminManageCustomerPageUIs.ADMIN_LOGOUT_LINK);
		clickToElement(driver, AdminManageCustomerPageUIs.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

}
