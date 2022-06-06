package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyDashboardPageUI;

public class MyProductReviewsPageObject extends BasePage {
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
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

	public void clickToLogoutButton() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_BUTTON);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_BUTTON);
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_BUTTON);
	}

	
}
