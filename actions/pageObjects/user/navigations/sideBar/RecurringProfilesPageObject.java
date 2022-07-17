package pageObjects.user.navigations.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class RecurringProfilesPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public RecurringProfilesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
