package pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailAddressTextbox;

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, emailAddressTextbox);
		sendkeyToElement(driver, emailAddressTextbox, emailAddress);
	}

	@FindBy(xpath = "//input[@id='pass']")
	private WebElement passwordTextbox;

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	@FindBy(xpath = "//button[@id='send2']")
	private WebElement loginButton;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-email']")
	private WebElement emailAddressEmptyErrorMessage;

	public String getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, emailAddressEmptyErrorMessage);
		return getElementText(driver, emailAddressEmptyErrorMessage);
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-pass']")
	private WebElement passwordEmptyErrorMessage;

	public String getPasswordEmptyErrorMessage() {
		waitForElementVisible(driver, passwordEmptyErrorMessage);
		return getElementText(driver, passwordEmptyErrorMessage);
	}

	@FindBy(xpath = "//div[@id='advice-validate-email-email']")
	private WebElement emailAddressInvalidErrorMessage;

	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, emailAddressInvalidErrorMessage);
		return getElementText(driver, emailAddressInvalidErrorMessage);
	}

	@FindBy(xpath = "//div[@id='advice-validate-password-pass']")
	private WebElement passwordInvalidErrorMessage;

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, passwordInvalidErrorMessage);
		return getElementText(driver, passwordInvalidErrorMessage);
	}

	@FindBy(xpath = "//li[@class='error-msg']//span")
	private WebElement emailPasswordIncorrectErrorMessage;

	public String getEmailPasswordIncorrectErrorMessage() {
		waitForElementVisible(driver, emailPasswordIncorrectErrorMessage);
		return getElementText(driver, emailPasswordIncorrectErrorMessage);
	}

	@FindBy(xpath = "//a[@title='Create an Account']")
	private WebElement createAccountButton;

	public void clickToCreateAccountButton() {
		waitForElementClickable(driver, createAccountButton);
		clickToElement(driver, createAccountButton);
	}

}
