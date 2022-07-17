package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;
import pageUIs.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToMiddleNameTextbox(String middleName) {
        waitForElementVisible(driver, RegisterPageUI.MIDDLE_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void inputToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToPasswordConfirmTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX, password);
    }

    public UserMyDashboardPageObject clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }

}
