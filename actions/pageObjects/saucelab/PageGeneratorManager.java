package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static SauceLabLoginPageObject getSauceLabLoginPage(WebDriver driver) {
        return new SauceLabLoginPageObject(driver);
    }

    public static SauceLabHomePageObject getSauceLabHomePage(WebDriver driver) {
        return new SauceLabHomePageObject(driver);
    }
}
