package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

/**
 * @author Dung Ta - ttdung1901@gmail.com @
 */
public class BasePage {
	public static BasePage getBasePageInstance() {
		return new BasePage();
	}

	/* Web Browser */
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPersence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPersence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPersence(driver).dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		waitForAlertPersence(driver).sendKeys(valueToSendkey);
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPersence(driver).getText();
	}

	public void switchToWindowByID(WebDriver driver, String expectedID) {
		Set<String> allTabIDs = driver.getWindowHandles();
		for (String id : allTabIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

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
	 * Define locator by using REST PARAMETER
	 * 
	 * @param locator
	 * @param locatorValues
	 */
	public String castRestParameter(String locator, String... locatorValues) {
		return locator = String.format(locator, (Object[]) locatorValues);
	}

	/**
	 * @implNote Using for: id/ class/ name/ xpath/ css.
	 * @implNote Locator conventions: id=/ class=/ name=/ xpath=/ css=.
	 * @implSpec Access Modifier: private
	 * @param locator
	 * @return by
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
	 * Return an element
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	/**
	 * Return a list of elements
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	/**
	 * Click to Element by FIXED LOCATOR
	 * 
	 * @param driver
	 * @param locator
	 */
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}

	/**
	 * Click to Element by using locator REST PARAMETER values
	 * 
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 */
	public void clickToElement(WebDriver driver, String locator, String... locatorValues) {
		getWebElement(driver, castRestParameter(locator, locatorValues)).click();
	}

	/**
	 * Send key to Element by using FIXED LOCATOR
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
	 * Send key to Element by using locator REST PARAMETER values
	 * 
	 * @param driver
	 * @param valueToInput
	 * @param locator
	 * @param locatorValues
	 */
	public void sendkeyToElement(WebDriver driver, String valueToInput, String locator, String... locatorValues) {
		getWebElement(driver, castRestParameter(locator, locatorValues)).clear();
		getWebElement(driver, castRestParameter(locator, locatorValues)).sendKeys(valueToInput);
	}

	/**
	 * Get texts in Element by using FIXED LOCATOR
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}

	/**
	 * Get texts in Element by using locator REST PARAMETER values
	 * 
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 * @return
	 */
	public String getElementText(WebDriver driver, String locator, String... locatorValues) {
		return getWebElement(driver, castRestParameter(locator, locatorValues)).getText();
	}

	/**
	 * Select an item in a default drop down by using FIXED LOCATOR.
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
	 * Select an item in a default drop down by using locator REST PARAMETER values
	 * 
	 * @param driver
	 * @param itemText
	 * @param locator
	 * @param locatorValues
	 */
	public void selectItemInDefaultDropDown(WebDriver driver, String itemText, String locator,
			String... locatorValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, locatorValues)));
		select.selectByVisibleText(itemText);
	}

	/**
	 * Get text from the FIRST SELECTED item in drop down list by using FIXED
	 * LOCATOR
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
	 * Get text from the FIRST SELECTED item in drop down list by using locator REST
	 * PARAMETER values
	 * 
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 * @return
	 */
	public String getFirstSelectedTextItem(WebDriver driver, String locator, String... locatorValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, locatorValues)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator,
			String selectItemText) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(2);

		List<WebElement> childItems = new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
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
	 * @param locatorValues
	 * @return
	 */
	public String getElementAttribute(WebDriver driver, String attributeName, String locator, String... locatorValues) {
		return getWebElement(driver, castRestParameter(locator, locatorValues)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}

	public int getListElementSize(WebDriver driver, String locator) {
		return getListElement(driver, locator).size();
	}

	public void checkToCheckBoxOrRadioButton(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)) {
			clickToElement(driver, locator);
		}
	}

	/**
	 * Verify whether the element is displayed by using FIXED LOCATOR
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}

	/**
	 * Verify whether the element is DISABLED by using locator REST PARAMETER values
	 * 
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 * @return Boolean
	 */
	public boolean isElementDisplayed(WebDriver driver, String locator, String... locatorValues) {
		return getWebElement(driver, castRestParameter(locator, locatorValues)).isDisplayed();
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
	 * @param locatorValues
	 * @return Boolean
	 */
	public boolean isElementEnabled(WebDriver driver, String locator, String... locatorValues) {
		return getWebElement(driver, castRestParameter(locator, locatorValues)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public Object executeJavascriptToBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	/**
	 * Highlight the active element by using FIXED LOCATOR
	 * 
	 * @implSpec Java script Executor
	 * @param driver
	 * @param locator
	 */
	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	/**
	 * Highlight the active element by using locator REST PARAMETER values.
	 * 
	 * @implSpec Java script Executor
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 */
	public void hightlightElement(WebDriver driver, String locator, String... locatorValues) {
		WebElement element = getWebElement(driver, castRestParameter(locator, locatorValues));
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	/**
	 * Click to WebElement by using FIXED LOCATOR.
	 * 
	 * @implSpec Java script Executor
	 * @param driver
	 * @param locator
	 */
	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	/**
	 * Click to WebElement by using locator REST PARAMETER values.
	 * 
	 * @implSpec Java script Executor
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 */
	public void clickToElementByJS(WebDriver driver, String locator, String... locatorValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				getWebElement(driver, castRestParameter(locator, locatorValues)));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}

	public String getPageDomain(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.domain");
	}

	public String getPageURL(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.URL");
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
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
	 * Wait for WebElement clickable by using locator REST PARAMETER values.
	 * 
	 * @param driver
	 * @param locator
	 * @param locatorValues
	 */
	public void waitForElementClickable(WebDriver driver, String locator, String... locatorValues) {
		new WebDriverWait(driver, longTimeout).until(
				ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, locatorValues))));
	}

	public void checkCheckboxOrRadioButtonByJS(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void uncheckCheckboxByJS(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private long longTimeout = 30;

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
