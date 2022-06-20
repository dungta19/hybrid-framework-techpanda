package pageUIs.user;

public class LoginPageUI {
	public static final String EMAIL_ADDRESS_TEXTBOX = "xpath=//input[@id='email']";
	public static final String EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE = "xpath=//div[@id='advice-required-entry-email']";
	public static final String EMAIL_ADDRESS_INVALID_ERROR_MESSAGE = "xpath=//div[@id='advice-validate-email-email']";

	public static final String PASSWORD_TEXTBOX = "id=pass";
	public static final String PASSWORD_EMPTY_ERROR_MESSAGE = "Xpath=//div[@id='advice-required-entry-pass']";
	public static final String PASSWORD_INVALID_ERROR_MESSAGE = "XPATH=//div[@id='advice-validate-password-pass']";

	public static final String EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span";

	public static final String LOGIN_BUTTON = "xpath=//button[@id='send2']";
	public static final String CREATE_ACCOUNT_BUTTON = "xpath=//a[@title='Create an Account']";

}
