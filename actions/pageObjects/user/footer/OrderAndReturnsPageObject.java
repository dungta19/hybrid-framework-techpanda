package pageObjects.user.footer;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class OrderAndReturnsPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public OrderAndReturnsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
