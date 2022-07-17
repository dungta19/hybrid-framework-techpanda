package pageObjects.user.navigations.footer;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class PrivacyPolicyPageObject extends FooterContainerPageObject {
    WebDriver driver;

    public PrivacyPolicyPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
