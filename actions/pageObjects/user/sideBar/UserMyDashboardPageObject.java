package pageObjects.user.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;
import pageUIs.user.MyDashboardPageUI;

public class UserMyDashboardPageObject extends SideBarContainerPageObject {
	WebDriver driver;

	public UserMyDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getSuccessRegisterMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.SUCCESS_REGISTER_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.SUCCESS_REGISTER_MESSAGE);
	}

	public String getUserInfoText() {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFO_TEXT);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFO_TEXT);
	}

	public boolean isAccountInformationMessageSavedDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.SUCCESS_SAVED_MESSAGE);
		return isElementDisplayed(driver, MyDashboardPageUI.SUCCESS_SAVED_MESSAGE);
	}

}
