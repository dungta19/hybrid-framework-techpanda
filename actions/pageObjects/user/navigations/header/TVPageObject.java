package pageObjects.user.navigations.header;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.HeaderContainerPageObject;

public class TVPageObject extends HeaderContainerPageObject {
    WebDriver driver;

    public TVPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
