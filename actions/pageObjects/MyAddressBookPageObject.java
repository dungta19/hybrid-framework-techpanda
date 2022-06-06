package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAddressBookPageObject extends BasePage {
	WebDriver driver;

	public MyAddressBookPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
