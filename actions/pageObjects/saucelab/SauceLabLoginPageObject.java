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
		waitForElementVisible(driver, GlobalConstants.getGlobalConstants().getSaucelabUserNameTextbox());
		sendkeyToElement(driver, GlobalConstants.getGlobalConstants().getSaucelabUserNameTextbox(), userName);

	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, GlobalConstants.getGlobalConstants().getSaucelabPasswordTextbox());
		sendkeyToElement(driver, GlobalConstants.getGlobalConstants().getSaucelabPasswordTextbox(), password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, GlobalConstants.getGlobalConstants().getSaucelabLoginButton());
		clickToElement(driver, GlobalConstants.getGlobalConstants().getSaucelabLoginButton());
	}
}
