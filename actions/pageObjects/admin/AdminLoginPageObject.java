package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUIs;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputUserNameTextBox(String userName) {
		waitForElementVisible(driver, AdminLoginPageUIs.ADMIN_USER_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUIs.ADMIN_USER_NAME_TEXTBOX, userName);
	}

	public void inputUserPasswordTextBox(String password) {
		waitForElementVisible(driver, AdminLoginPageUIs.ADMIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUIs.ADMIN_PASSWORD_TEXTBOX, password);
	}

	public AdminManageCustomerPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUIs.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUIs.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminManageCustomer(driver);
	}

}
