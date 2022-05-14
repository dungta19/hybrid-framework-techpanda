package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CreateAccountPageUI;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class CreateAccountPageObject extends BasePage {
	WebDriver driver;

	public CreateAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CreateAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CreateAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToMiddleNameTextbox(String middleName) {
		waitForElementVisible(driver, CreateAccountPageUI.MIDDLE_NAME_TEXTBOX);
		sendkeyToElement(driver, CreateAccountPageUI.MIDDLE_NAME_TEXTBOX, middleName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CreateAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CreateAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, CreateAccountPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CreateAccountPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, CreateAccountPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CreateAccountPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToPasswordConfirmTextbox(String password) {
		waitForElementVisible(driver, CreateAccountPageUI.PASSWORD_CONFIRM_TEXTBOX);
		sendkeyToElement(driver, CreateAccountPageUI.PASSWORD_CONFIRM_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, CreateAccountPageUI.REGISTER_BUTTON);
		clickToElement(driver, CreateAccountPageUI.REGISTER_BUTTON);
	}

}
