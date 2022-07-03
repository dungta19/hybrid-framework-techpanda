package pageUIs.jQuery;

public class HomePageUI {
	public static final String HEADER_TEXTBOX_BY_DYNAMIC_HEADER_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUES = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String MODIFY_BUTTONS = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[contains(@class,'%s')]";
	public static final String ACTIVE_PAGE_NUMBER = "xpath=//a[contains(@class,'active') and text()='%s']";
	public static final String PAGING_BY_PAGE_NUMBER = "xpath=//a[text()='%s']";

	public static final String HEADER_INDEX_BY_NAME = "xpath=//td[text()='%s']/preceding-sibling::td";
	public static final String CELL_BY_HEADER_INDEX_AND_ROW_INDEX = "xpath=//tr[%s]/td[%s]/input";
	public static final String LOAD_DATA = "xpath=//button[@id='btnLoad']";

	public static final String UPLOAD_FILE = "css=input[type='file']";
	public static final String ADDED_SUCESS_DYNAMIC_FILENAME = "xpath=//p[text()='%s']";
	public static final String START_UPLOAD_BUTTON = "css=table button.start";
	public static final String UPLOADED_SUCESS_DYNAMIC_FILENAME = "css=p.name a[title='%s']";

}
