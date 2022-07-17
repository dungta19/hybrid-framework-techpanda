package pageObjects.user.navigations.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.PageGeneratorManager;
import pageObjects.navigation.SideBarContainerPageObject;
import pageUIs.user.AccountInforPageUI;

public class AccountInfoPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public AccountInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, AccountInforPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AccountInforPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, AccountInforPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AccountInforPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailAddressTextBox(String email) {
        waitForElementVisible(driver, AccountInforPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, AccountInforPageUI.EMAIL_ADDRESS_TEXTBOX, email);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, AccountInforPageUI.CURRENT_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AccountInforPageUI.CURRENT_PASSWORD_TEXTBOX, password);
    }

    public UserMyDashboardPageObject clickToSaveButton() {
        waitForElementClickable(driver, AccountInforPageUI.SAVE_BUTTON);
        clickToElement(driver, AccountInforPageUI.SAVE_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }

}
