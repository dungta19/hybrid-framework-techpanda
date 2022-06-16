package pageObjects.user.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class MyDownloadableProductsPageObject extends SideBarContainerPageObject {
	WebDriver driver;

	public MyDownloadableProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
