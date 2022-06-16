package pageObjects.user.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class BillingAgreementsPageObject extends SideBarContainerPageObject {
	WebDriver driver;

	public BillingAgreementsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
