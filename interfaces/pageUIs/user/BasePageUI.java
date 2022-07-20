package pageUIs.user;

public class BasePageUI {
    public static final String MY_ACCOUNT_LINK = "xpath=//div[@class='footer']//a[@title='My Account']";

    public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String DYNAMIC_VALIDATION_ADVICE_MESSAGE_BY_TEXT = "xpath=//label[text()='%s']/following-sibling::div/div[@class='validation-advice']";
}
