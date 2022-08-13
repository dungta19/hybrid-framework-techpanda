package pageObjects.navigation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;
import pageUIs.navigation.HeaderContainerPageUIs;

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
