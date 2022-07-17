package pageObjects.user.navigations.sideBar;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;
import pageUIs.user.MyDashboardPageUI;

public class UserMyDashboardPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public UserMyDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get the success register message")
    public String getSuccessRegisterMessage() {
        waitForElementVisible(driver, MyDashboardPageUI.SUCCESS_REGISTER_MESSAGE);
        return getElementText(driver, MyDashboardPageUI.SUCCESS_REGISTER_MESSAGE);
    }

    @Step("Get user information text after sucessfully logined in")
    public String getUserInfoText() {
        waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFO_TEXT);
        return getElementText(driver, MyDashboardPageUI.CONTACT_INFO_TEXT);
    }

    @Step("Verify whether the Account information message is displayed")
    public boolean isAccountInformationMessageSavedDisplayed() {
        waitForElementVisible(driver, MyDashboardPageUI.SUCCESS_SAVED_MESSAGE);
        return isElementDisplayed(driver, MyDashboardPageUI.SUCCESS_SAVED_MESSAGE);
    }

}
