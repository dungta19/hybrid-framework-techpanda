package pageObjects.user.navigations.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class AddressBookPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public AddressBookPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
