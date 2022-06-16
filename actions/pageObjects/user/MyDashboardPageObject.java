package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
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
