package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_03_Data_Type {
	// Primitive type/ value type: kiểu dữ liệu nguyên thủy
	byte bNumber = 6; // Số nguyên

	short sNumner = 1500; // Số nguyên

	int iNumber = 65000; // Số nguyên

	long lNumber = 65000; // Số nguyên

	float fNumber = 16.98f; // Số thập phân

	double dNumber = 16.98d; // Số thập phân

	char cChar = '1';

	boolean bStatus = false;

	// Reference type: Tham chiếu

	// String
	String address = "Ho Chi Minh";

	// Array
	String[] studentAddress = { "Ha Noi", address, "Da Nang" }; // Array with String
	Integer[] studentNumber = { 15, 20, 30 }; // Array with Integer

	// Class
	Topic_02_Data_Type topic;

	// Interface
	WebDriver driver;

	// Object
	Object aObject;

	// Collection

	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();

	public void clickToElement() {
		address.trim();

		studentAddress.clone();

		driver.getCurrentUrl();

		aObject.toString();

		homePageLinks.size();

		allWindows.clear();
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		topic.address = "Ha Noi";

	}

	public static void main(String[] args) {
		// Local Variable
		System.out.println("alo");

	}

}
