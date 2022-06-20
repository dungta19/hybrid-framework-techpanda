package pageUIs.user;

public class MyDashboardPageUI {
	public static final String CONTACT_INFO_TEXT = "xpath=//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']";
	public static final String SUCCESS_REGISTER_MESSAGE = "xpath=//li[@class='success-msg']//span";
	public static final String ACCOUNT_BUTTON = "xpath=//div[@class='account-cart-wrapper']//span[@class='label']";
	public static final String LOGOUT_BUTTON = "xpath=//div[@id='header-account']//a[@title='Log Out']";
	public static final String SUCCESS_SAVED_MESSAGE = "xpath=//li[@class='success-msg']//span[text()='The account information has been saved.']";

	public static final String LOGOUT_SUCCESS_MESSAGE = "xpath=//div[@class='page-title']//h1[text()='You are now logged out']";

}
