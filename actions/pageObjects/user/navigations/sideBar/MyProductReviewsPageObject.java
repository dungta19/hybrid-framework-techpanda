package pageObjects.user.navigations.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class MyProductReviewsPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public MyProductReviewsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
