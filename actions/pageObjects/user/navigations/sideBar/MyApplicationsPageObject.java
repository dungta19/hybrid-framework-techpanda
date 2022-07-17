package pageObjects.user.navigations.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class MyApplicationsPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public MyApplicationsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
