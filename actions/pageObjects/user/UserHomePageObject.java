package pageObjects.user;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageUIs.navigation.FooterContainerPageUIs;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Login Page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

}
