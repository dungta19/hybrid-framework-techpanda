package pageObjects.user.footer;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class AdvancedSearchPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public AdvancedSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
