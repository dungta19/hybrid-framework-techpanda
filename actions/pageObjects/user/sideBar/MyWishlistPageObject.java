package pageObjects.user.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class MyWishlistPageObject extends SideBarContainerPageObject {
	WebDriver driver;

	public MyWishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
