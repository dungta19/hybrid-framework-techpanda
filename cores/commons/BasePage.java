package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.navigation.FooterContainerPageObject;
import pageObjects.navigation.HeaderContainerPageObject;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.navigation.SideBarContainerPageObject;
import pageObjects.user.UserHomePageObject;
import pageUIs.jQuery.HomePageUI;

/**
 * BaseTest class is including all general custom methods that can use for all classes
 *
 * @author Dung Ta - ttdung1901@gmail.com @
 */
public class BasePage {
    public static BasePage getBasePageInstance() {
        return new BasePage();
    }

    /* Web Browser */

    /**
     * The method is to open a page by using a provided url
     *
     * @param driver
     * @param pageUrl
     */
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    /**
     * The method is to return the title value of the active page
     *
     * @param driver
     * @return String
     */
    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    /**
     * The method is to return the url value of the active page
     *
     * @param driver
     * @return String
     */
    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    /**
     * The method is to return the source value of the active page
     *
     * @param driver
     * @return String
     */
    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    /**
     * The method is to navigate the active page to previous page
     *
     * @param driver
     */
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    /**
     * The method is to navigate the active page to forward page
     *
     * @param driver
     */
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    /**
     * The method is to refresh the active page
     *
     * @param driver
     */
    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    /**
     * The method is to wait for the alert screen is presented.
     *
     * @param driver
     * @return
     */
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * The method is to accept the Alert popup
     *
     * @param driver
     */
    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    /**
     * The method is to cancel the Alert popup
     *
     * @param driver
     */
    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    /**
     * The method is to enter an appropriate value to alert popup.
     *
     * @param driver
     * @param valueToSendkey
     */
    public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
        waitForAlertPresence(driver).sendKeys(valueToSendkey);
    }

    /**
     * The method is to get the alert text/title.
     *
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    /**
     * The method is to switch between windows by IDs.
     *
     * @param driver
     * @param expectedID
     */
    public void switchToWindowByID(WebDriver driver, String expectedID) {
        Set<String> allTabIDs = driver.getWindowHandles();
        for (String id : allTabIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    /**
     * The method is to switch between windows by page title.
     *
     * @param driver
     * @param expectedTitle
     */
    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allTabIDs = driver.getWindowHandles();
        for (String id : allTabIDs) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (!actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    /**
     * The method is to close all windows except the parent page.
     *
     * @param driver
     * @param parentID
     * @return
     */
    public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        if (driver.getWindowHandles().size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /* Web Element */

    /**
     * The method is to define locator by using REST PARAMETER.
     *
     * @param locator
     * @param castValue
     */
    public String castRestParameter(String locator, String... castValue) {
        return locator = String.format(locator, (Object[]) castValue);
    }

    /**
     * This method is to identify the type of provided locator by the invention of prefix of a String that starts with id=/ class=/ name=/ xpath=/ css= .
     *
     * @param locator
     * @return by
     * @implNote Using for: id/ class/ name/ xpath/ css.
     * @implNote Locator conventions: id=/ class=/ name=/ xpath=/ css=.
     * @implSpec Access Modifier: private
     */
    private By getByLocator(String locator) {
        By by = null;
        if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
            by = By.id(locator.substring(3));
        } else if (locator.startsWith("class=") || locator.startsWith("CLASS=") || locator.startsWith("Class=")) {
            by = By.className(locator.substring(6));
        } else if (locator.startsWith("name=") || locator.startsWith("NAME=") || locator.startsWith("Name=")) {
            by = By.name(locator.substring(5));
        } else if (locator.startsWith("css=") || locator.startsWith("CSS=") || locator.startsWith("Css=")) {
            by = By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
            by = By.xpath(locator.substring(6));
        } else {
            throw new RuntimeException("Locator is invalid!");
        }
        return by;
    }

    /**
     * The method is to get an element by using a related locator.
     *
     * @param driver
     * @param locator
     * @return
     */
    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    /**
     * The method is to get a list of elements by using a related locator.
     *
     * @param driver
     * @param locator
     * @return
     */
    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    /**
     * Custom method to click to Element by FIXED LOCATOR
     *
     * @param driver
     * @param locator
     */
    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    /**
     * Custom method to click to Element by using locator REST PARAMETER values
     *
     * @param driver
     * @param locator
     * @param castValue
     */
    public void clickToElement(WebDriver driver, String locator, String... castValue) {
        getWebElement(driver, castRestParameter(locator, castValue)).click();
    }

    /**
     * Custom method to send key to Element by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @param valueToInput
     */
    public void sendkeyToElement(WebDriver driver, String locator, String valueToInput) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(valueToInput);
    }

    /**
     * Custom method to send key to Element by using locator REST PARAMETER values
     *
     * @param driver
     * @param valueToInput
     * @param locator
     * @param castValue
     */
    public void sendkeyToElement(WebDriver driver, String valueToInput, String locator, String... castValue) {
        getWebElement(driver, castRestParameter(locator, castValue)).clear();
        getWebElement(driver, castRestParameter(locator, castValue)).sendKeys(valueToInput);
    }

    /**
     * Custom method to get texts in Element by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    /**
     * Custom method to get texts in Element by using locator REST PARAMETER values
     *
     * @param driver
     * @param locator
     * @param castValue
     * @return
     */
    public String getElementText(WebDriver driver, String locator, String... castValue) {
        return getWebElement(driver, castRestParameter(locator, castValue)).getText();
    }

    /**
     * Custom method to select an item in a default drop down by using FIXED LOCATOR.
     *
     * @param driver
     * @param locator
     * @param itemText
     */
    public void selectItemInDefaultDropDown(WebDriver driver, String locator, String itemText) {
        Select select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(itemText);
    }

    /**
     * Custom method to select an item in a default drop down by using locator REST PARAMETER values
     *
     * @param driver
     * @param itemText
     * @param locator
     * @param castValue
     */
    public void selectItemInDefaultDropDown(WebDriver driver, String itemText, String locator, String... castValue) {
        Select select = new Select(getWebElement(driver, castRestParameter(locator, castValue)));
        select.selectByVisibleText(itemText);
    }

    /**
     * Custom method to get text from the FIRST SELECTED item in drop down list by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getFirstSelectedTextItem(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Custom method to get text from the FIRST SELECTED item in drop down list by using locator REST PARAMETER values
     *
     * @param driver
     * @param locator
     * @param castValue
     * @return
     */
    public String getFirstSelectedTextItem(WebDriver driver, String locator, String... castValue) {
        Select select = new Select(getWebElement(driver, castRestParameter(locator, castValue)));
        return select.getFirstSelectedOption().getText();
    }

    /**
     * This method is to verify whether the dropdown is able to multiple select.
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        return select.isMultiple();
    }

    /**
     * The method is to select the item in custom dropdown.
     *
     * @param driver
     * @param parentLocator
     * @param childLocator
     * @param selectItemText
     */
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String selectItemText) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(2);

        List<WebElement> childItems = new WebDriverWait(driver, longTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
        for (WebElement tempElement : childItems) {

            if (tempElement.getText().equals(selectItemText)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
                sleepInSecond(1);
                tempElement.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    /**
     * Get a WebElement attribute value by using FIXED LOCATOR
     *
     * @param driver
     * @param attributeName
     * @param locator
     * @return
     */
    public String getElementAttribute(WebDriver driver, String attributeName, String locator) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    /**
     * Get a WebElement attribute value by using locator REST PARAMETER values.
     *
     * @param driver
     * @param attributeName
     * @param locator
     * @param castValue
     * @return
     */
    public String getElementAttribute(WebDriver driver, String attributeName, String locator, String... castValue) {
        return getWebElement(driver, castRestParameter(locator, castValue)).getAttribute(attributeName);
    }

    /**
     * Custom method is to get the CSS value in a provided web element.
     *
     * @param driver
     * @param locator
     * @param propertyName
     * @return
     */
    public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getWebElement(driver, locator).getCssValue(propertyName);
    }

    /**
     * Custom method to get List WebElement size by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @return
     */
    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    /**
     * Custom method to get List WebElements size by using locator REST PARAMETER values
     *
     * @param driver
     * @param locator
     * @param castValue
     * @return
     */
    public int getListElementSize(WebDriver driver, String locator, String... castValue) {
        return getListElement(driver, castRestParameter(locator, castValue)).size();
    }

    /**
     * Custom method is to check the checkbox or radio button.
     *
     * @param driver
     * @param locator
     */
    public void checkToCheckBoxOrRadioButton(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    /**
     * Custom method is to deselect the checkbox or radio button.
     *
     * @param driver
     * @param locator
     */
    public void uncheckToCheckBox(WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)) {
            clickToElement(driver, locator);
        }
    }

    /**
     * Custom method is to return the status of the web element if it is displayed by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        try {
            return getWebElement(driver, locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Custom method is to return the status of the web element if it is undisplayed
     *
     * @param driver
     * @param locator
     * @return boolean
     */
    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, shorTimeout);
        List<WebElement> elements = getListElement(driver, locator);
        overrideGlobalTimeout(driver, longTimeout);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The method is to override the current timeout to another preset timeout that accommodates the context.
     *
     * @param driver
     * @param timeOut
     */
    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    /**
     * Verify whether the element is DISABLED by using locator REST PARAMETER values
     *
     * @param driver
     * @param locator
     * @param castValue
     * @return Boolean
     */
    public boolean isElementDisplayed(WebDriver driver, String locator, String... castValue) {
        return getWebElement(driver, castRestParameter(locator, castValue)).isDisplayed();
    }

    /**
     * Verify whether the element is ENABLED by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @return Boolean
     */
    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    /**
     * Verify whether the element is ENABLED by using locator REST PARAMETER values
     *
     * @param driver
     * @param locator
     * @param castValue
     * @return Boolean
     */
    public boolean isElementEnabled(WebDriver driver, String locator, String... castValue) {
        return getWebElement(driver, castRestParameter(locator, castValue)).isEnabled();
    }

    /**
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    /**
     * @param driver
     * @param locator
     */
    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    /**
     * @param driver
     * @param locator
     */
    public void switchToDefaultContent(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }

    /**
     * @param driver
     * @param locator
     */
    public void hoverMouseToElement(WebDriver driver, String locator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locator)).perform();
    }

    /**
     * @param driver
     * @param locator
     */
    public void rightClickToElement(WebDriver driver, String locator) {
        Actions action = new Actions(driver);
        action.contextClick(getWebElement(driver, locator)).perform();
    }

    /**
     * @param driver
     * @param locator
     */
    public void doubleClickToElement(WebDriver driver, String locator) {
        Actions action = new Actions(driver);
        action.doubleClick(getWebElement(driver, locator)).perform();
    }

    /**
     * @param driver
     * @param sourceLocator
     * @param targetLocator
     */
    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        Actions action = new Actions(driver);
        action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    /**
     * @param driver
     * @param key
     * @param locator
     * @param castValue
     */
    public void pressKeyToElement(WebDriver driver, Keys key, String locator, String... castValue) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, castRestParameter(locator, castValue)), key).perform();
    }

    /**
     * @param driver
     * @param key
     * @param locator
     */
    public void pressKeyToElement(WebDriver driver, Keys key, String locator) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, locator), key).perform();
    }

    /**
     * @param driver
     * @param javaScript
     * @return
     */
    public Object executeJavascriptToBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    /**
     * @param driver
     * @return
     */
    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    /**
     * @param driver
     * @param textExpected
     * @return
     */
    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    /**
     * @param driver
     */
    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * @param driver
     * @param url
     */
    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
    }

    /**
     * Highlight the active element by using FIXED LOCATOR
     *
     * @param driver
     * @param locator
     * @implSpec Java script Executor
     */
    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    /**
     * Highlight the active element by using locator REST PARAMETER values.
     *
     * @param driver
     * @param locator
     * @param castValue
     * @implSpec Java script Executor
     */
    public void hightlightElement(WebDriver driver, String locator, String... castValue) {
        WebElement element = getWebElement(driver, castRestParameter(locator, castValue));
        String originalStyle = element.getAttribute("style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    /**
     * Click to WebElement by using FIXED LOCATOR.
     *
     * @param driver
     * @param locator
     * @implSpec Java script Executor
     */
    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    /**
     * Click to WebElement by using locator REST PARAMETER values.
     *
     * @param driver
     * @param locator
     * @param castValue
     * @implSpec Java script Executor
     */
    public void clickToElementByJS(WebDriver driver, String locator, String... castValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, castRestParameter(locator, castValue)));
    }

    /**
     * @param driver
     * @param locator
     */
    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    /**
     * @param driver
     * @param locator
     */
    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    /**
     * @param driver
     * @param locator
     * @param value
     */
    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    /**
     * @param driver
     * @param locator
     * @param attributeRemove
     */
    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    /**
     * @param driver
     * @param locator
     * @return
     */
    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    /**
     * @param driver
     * @param locator
     * @return
     */
    public boolean isImageLoaded(WebDriver driver, String locator) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
        if (status) {
            return true;
        }
        return false;
    }

    /**
     * @param driver
     * @return
     */
    public String getPageDomain(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.domain");
    }

    /**
     * @param driver
     * @return
     */
    public String getPageURL(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.URL");
    }

    /**
     * Wait for WebElement VISIBLE by using FIXED LOCATOR.
     *
     * @param driver
     * @param locator
     */
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    /**
     * Wait for WebElement VISIBLE by using locator REST PARAMETER values.
     *
     * @param driver
     * @param locator
     * @param castValue
     */
    public void waitForElementVisible(WebDriver driver, String locator, String... castValue) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator, castValue))));
    }

    /**
     * Wait for WebElement INVISIBLE by using FIXED LOCATOR.
     *
     * @param driver
     * @param locator
     */
    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    /**
     * Wait for element is un-displayed by overriding short Timeout.
     *
     * @param driver
     * @param locator
     */
    public void waitForElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, shorTimeout);
        new WebDriverWait(driver, shorTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
        overrideGlobalTimeout(driver, longTimeout);
    }

    /**
     * Wait for WebElement INVISIBLE by using locator REST PARAMETER values.
     *
     * @param driver
     * @param locator
     * @param castValue
     */
    public void waitForElementInvisible(WebDriver driver, String locator, String... castValue) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, castValue))));
    }

    /**
     * Wait for WebElement clickable by using FIXED LOCATOR.
     *
     * @param driver
     * @param locator
     */
    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    /**
     * Use for upload file
     *
     * @param driver
     * @param element
     */
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait for WebElement clickable by using locator REST PARAMETER values.
     *
     * @param driver
     * @param locator
     * @param castValue
     */
    public void waitForElementClickable(WebDriver driver, String locator, String... castValue) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, castValue))));
    }

    /**
     * @param driver
     * @param locator
     */
    public void checkCheckboxOrRadioButtonByJS(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (!element.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    /**
     * @param driver
     * @param locator
     */
    public void uncheckCheckboxByJS(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (element.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    /**
     * @param driver
     * @param fileNames
     */
    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String uploadFilePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";

        for (String file : fileNames) {
            fullFileName = fullFileName + uploadFilePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getWebElement(driver, HomePageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }

    /**
     * @param timeInSecond
     */
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param driver
     * @return
     */
    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    /**
     * @param driver
     * @param cookies
     */
    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(2);

    }

    /**
     * Timeout presets for Wait methods
     */
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shorTimeout = GlobalConstants.SHORT_TIMEOUT;

    /**
     * Call out pages in Side Bar menu
     *
     * @param driver
     * @return
     */
    public SideBarContainerPageObject getSideBarMyAccountPage(WebDriver driver) {
        return new SideBarContainerPageObject(driver);
    }

    /**
     * Call out pages in Footer menu
     *
     * @param driver
     * @return
     */
    public FooterContainerPageObject getFooterContainerPage(WebDriver driver) {
        return new FooterContainerPageObject(driver);
    }

    /**
     * Call out pages in Header menu
     *
     * @param driver
     * @return
     */
    public HeaderContainerPageObject getHeaderContainerPage(WebDriver driver) {
        return new HeaderContainerPageObject(driver);
    }

    /**
     * Open User Login Page
     *
     * @param driver
     * @param userURL
     * @return
     */
    public UserHomePageObject openUserHomePage(WebDriver driver, String userURL) {
        openPageUrl(driver, userURL);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    /**
     * Open Admin Login Page
     *
     * @param driver
     * @param adminURL
     * @return
     */
    public AdminLoginPageObject openAdminLoginPage(WebDriver driver, String adminURL) {
        openPageUrl(driver, adminURL);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

}