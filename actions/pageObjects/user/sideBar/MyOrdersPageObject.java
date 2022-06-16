package pageObjects.user.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class MyOrdersPageObject extends SideBarContainerPageObject {
	WebDriver driver;

	public MyOrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
