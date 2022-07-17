package pageObjects.user.navigations.header;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.HeaderContainerPageObject;

public class MobilePageObject extends HeaderContainerPageObject {
    WebDriver driver;

    public MobilePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
