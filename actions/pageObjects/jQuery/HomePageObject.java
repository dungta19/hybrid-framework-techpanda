package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextBoxByHeaderName(String headerName, String inputValue) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_DYNAMIC_HEADER_NAME, headerName);
		sendkeyToElement(driver, inputValue, HomePageUI.HEADER_TEXTBOX_BY_DYNAMIC_HEADER_NAME, headerName);
		pressKeyToElement(driver, Keys.ENTER, HomePageUI.HEADER_TEXTBOX_BY_DYNAMIC_HEADER_NAME, headerName);
	}

	public boolean isRowValuesDisplayed(String femaleValue, String countryName, String maleValue, String totalValue) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUES, femaleValue, countryName, maleValue, totalValue);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUES, femaleValue, countryName, maleValue, totalValue);
	}

	public void clickToModifyIconByCountryName(String countryName, String modifyAction) {
		waitForElementClickable(driver, HomePageUI.MODIFY_BUTTONS, countryName, modifyAction);
		clickToElement(driver, HomePageUI.MODIFY_BUTTONS, countryName, modifyAction);
	}

	public void clickToPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageNumberActivated(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
	}

	public void enterToTextBoxByHeaderNameAndRowNumber(String headerName, String rowNumber, String valueToInput) {
		int headerIndex = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerName) + 1;
		waitForElementVisible(driver, HomePageUI.CELL_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(headerIndex));
		sendkeyToElement(driver, valueToInput, HomePageUI.CELL_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(headerIndex));

	}

	public void clickToLoadDataButton() {
		waitForElementVisible(driver, HomePageUI.LOAD_DATA);
		clickToElement(driver, HomePageUI.LOAD_DATA);
	}

	public boolean isFileUploadedByFileName(String fileName) {
		waitForElementVisible(driver, HomePageUI.ADDED_SUCESS_DYNAMIC_FILENAME, fileName);
		return isElementDisplayed(driver, HomePageUI.ADDED_SUCESS_DYNAMIC_FILENAME, fileName);
	}

	public void clickToStartUploadButton() {
		List<WebElement> startButtonElements = getListElement(driver, HomePageUI.START_UPLOAD_BUTTON);
		for (WebElement startButton : startButtonElements) {
			waitForElementClickable(driver, startButton);
			startButton.click();
			sleepInSecond(2);
		}

	}

	public boolean isFileUploadedSuccessful(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_SUCESS_DYNAMIC_FILENAME, fileName);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_SUCESS_DYNAMIC_FILENAME, fileName);
	}

}
