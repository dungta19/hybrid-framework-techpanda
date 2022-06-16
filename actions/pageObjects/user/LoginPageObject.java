package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageUIs.user.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

	public String getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
	}

	public String getPasswordEmptyErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
	}

	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
	}

	public String getEmailPasswordIncorrectErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
	}

	public void clickToCreateAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
	}

}
