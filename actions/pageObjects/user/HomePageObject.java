package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.PageGeneratorManager;
import pageUIs.navigation.FooterContainerPageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject openLoginPage() {
		waitForElementClickable(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, FooterContainerPageUIs.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
