package pageObjects.user.navigations.sideBar;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarContainerPageObject;

public class NewsletterSubscriptionsPageObject extends SideBarContainerPageObject {
    WebDriver driver;

    public NewsletterSubscriptionsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
