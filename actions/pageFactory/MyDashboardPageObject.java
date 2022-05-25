package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class MyDashboardPageObject extends BasePageFactory {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@class='success-msg']//span")
	private WebElement successRegisterMessage;

	public String getSuccessRegisterMessage() {
		waitForElementVisible(driver, successRegisterMessage);
		return getElementText(driver, successRegisterMessage);
	}

	@FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']")
	private WebElement userInfoText;

	public String getUserInfoText() {
		waitForElementVisible(driver, userInfoText);
		return getElementText(driver, userInfoText);
	}

	@FindBy(xpath = "//div[@id='header-account']//a[@title='Log Out']")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@class='account-cart-wrapper']//span[@class='label']")
	private WebElement accountButton;

	public void clickToLogoutButton() {
		waitForElementClickable(driver, accountButton);
		clickToElement(driver, accountButton);
		waitForElementClickable(driver, logoutButton);
		clickToElement(driver, logoutButton);
	}

}
