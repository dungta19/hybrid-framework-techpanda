package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.HomePageObject;
import pageObjects.user.MyDashboardPageObject;
import pageUIs.navigation.HeaderContainerPageUIs;
import pageUIs.user.MyDashboardPageUI;

public class HeaderContainerPageObject extends BasePage {
	WebDriver driver;

	public HeaderContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLogoutButton() {
		waitForElementClickable(driver, HeaderContainerPageUIs.ACCOUNT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.ACCOUNT_LINK);

		waitForElementClickable(driver, HeaderContainerPageUIs.LOGOUT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.LOGOUT_LINK);

		waitForElementInvisible(driver, MyDashboardPageUI.LOGOUT_SUCCESS_MESSAGE);
		return PageGeneratorManager.getHomePage(driver);

	}

	public MyDashboardPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HeaderContainerPageUIs.ACCOUNT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.ACCOUNT_LINK);

		waitForElementClickable(driver, HeaderContainerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, HeaderContainerPageUIs.MY_ACCOUNT_LINK);

		return PageGeneratorManager.getMyDashboardPage(driver);
	}
}
