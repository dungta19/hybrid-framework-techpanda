package pageObjects.user.navigations.footer;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class SiteMapPageObject extends FooterContainerPageObject {
    WebDriver driver;

    public SiteMapPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
