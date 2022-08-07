package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelab.SauceLabHomePageObjectUI;

public class SauceLabHomePageObject extends BasePage {
    WebDriver driver;

    public SauceLabHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sortItemByText(String valueToSellect) {
        waitForElementVisible(driver, SauceLabHomePageObjectUI.SAUCELAB_SORT_DROPDOWN);
        selectItemInDefaultDropDown(driver, SauceLabHomePageObjectUI.SAUCELAB_SORT_DROPDOWN, valueToSellect);
        
    }

    public boolean isProductNamesSortedAscending() {
        waitForElementVisible(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_NAMES);
        return isDataTextSortedCorrectly(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_NAMES, true, false);
    }

    public boolean isProductNamesSortedDescending() {
        waitForElementVisible(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_NAMES);
        return isDataTextSortedCorrectly(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_NAMES, false, true);
    }

    public boolean isProductPricesSortedAscending() {
        waitForElementVisible(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_PRICES);
        return isDataFloatSortedCorrectly(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_PRICES, true, false);
    }

    public boolean isProductPriceSortedDescending() {
        waitForElementVisible(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_PRICES);
        return isDataFloatSortedCorrectly(driver, SauceLabHomePageObjectUI.SAUCELAB_PRODUCT_PRICES, false, true);
    }
}
