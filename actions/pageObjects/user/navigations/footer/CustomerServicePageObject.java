package pageObjects.user.navigations.footer;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class CustomerServicePageObject extends FooterContainerPageObject {
    WebDriver driver;

    public CustomerServicePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
