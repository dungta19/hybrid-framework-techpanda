package pageObjects.saucelab;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;

public class SauceLabLoginPageObject extends BasePage {
    WebDriver driver;

    public SauceLabLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextBox(String userName) {
        waitForElementVisible(driver, GlobalConstants.SL_USER_NAME_TEXT_BOX);
        sendkeyToElement(driver, GlobalConstants.SL_USER_NAME_TEXT_BOX, userName);
        
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, GlobalConstants.SL_PASSWORD_TEXT_BOX);
        sendkeyToElement(driver, GlobalConstants.SL_PASSWORD_TEXT_BOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, GlobalConstants.SL_LOGIN_BUTTON);
        clickToElement(driver, GlobalConstants.SL_LOGIN_BUTTON);
    }
}
