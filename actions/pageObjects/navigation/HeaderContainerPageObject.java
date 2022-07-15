package pageObjects.navigation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.sideBar.UserMyDashboardPageObject;
import pageUIs.navigation.HeaderContainerPageUIs;
import pageUIs.user.MyDashboardPageUI;

public class HeaderContainerPageObject extends BasePage {
	WebDriver driver;

	public HeaderContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Logout button and navigate to Home Page")
	public UserHomePageObject clickToUserLogoutButton() {
		waitForElementClickable(driver, HeaderContainerPageUIs.ACCOUNT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.ACCOUNT_LINK);

		waitForElementClickable(driver, HeaderContainerPageUIs.LOGOUT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.LOGOUT_LINK);

		waitForElementUndisplayed(driver, MyDashboardPageUI.LOGOUT_SUCCESS_MESSAGE);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public UserMyDashboardPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HeaderContainerPageUIs.ACCOUNT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.ACCOUNT_LINK);

		waitForElementClickable(driver, HeaderContainerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.MY_ACCOUNT_LINK);

		return PageGeneratorManager.getUserMyDashboardPage(driver);
	}
}
