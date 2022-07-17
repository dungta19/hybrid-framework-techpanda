package pageObjects.user;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;
import pageUIs.user.LoginPageUI;
import pageUIs.user.RegisterPageUI;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input to email address textbox with value is {emailAddress}")
    public void inputToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    @Step("Input to password textbox with value is {password}")
    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login Button and navigate to My Dashboard Page")
    public UserMyDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }

    @Step("Get error message while using the empty email address")
    public String getEmailAddressEmptyErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
    }

    @Step("Get error message while using the empty password")
    public String getPasswordEmptyErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
    }

    @Step("Get error message while using the invalid email address")
    public String getEmailAddressInvalidErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
    }

    @Step("Get error message while using the invalid password")
    public String getPasswordInvalidErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
    }

    @Step("Get error message while using the incorrect password")
    public String getEmailPasswordIncorrectErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
    }

    @Step("Click to Create Account Button")
    public UserRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
        return PageGeneratorManager.getRegisterPageObject(driver);
    }

}
