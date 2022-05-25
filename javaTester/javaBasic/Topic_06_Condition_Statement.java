package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public void TC_01_If_Methods() {
		boolean status01 = 5 > 3;
		boolean status02 = 7 < 8;
		// Mệnh đề If
		if (status01) {
			System.out.println("Run condition: status = true");
		}

		// Hàm if kết hợp với toán tử so sánh 2 điều kiện.
		// Lưu ý: các phép toán tử so sánh chỉ dùng để so sánh các số với nhau
		if (status01 || status02) {
			System.out.println("Run condition: status = true");
		}
		// Mệnh đề If-else
		if (status01) {
			System.out.println("Run condition: status = true");
		} else {
			System.out.println("Run condition: status = false");
		}

		// Mệnh đề if-else-if
		if (status01) {
			System.out.println("Run condition: status = true");
		} else if (status01) {
			System.out.println("Run condition: status = false");
		} else {
			System.out.println("None of 2 conditions are true");
		}
		// Mệnh đề if-else rút gọn (toán tử tam nguyên)
		boolean status = (status01 != status02) ? true : false;
		System.out.println(status);
	}

	public void TC_02_If_WebDriver_Usages() {
		// Element luôn luôn có trong DOM dù trong popup hiển thị hay không
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			System.out.println("Run codes if sale popup is displayed");
		}

		// Element không có trong DOM khi popup hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
			System.out.println("Run codes if sale popup is displayed");
		}

		// Uncheck checkbox
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if (languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}

		// Check checkbox
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}

	}

	public void TC_03_If_Else_WebDriver_Usages() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Set condition for Webbrowser drivers.
		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by Javascript Executor");
		} else {
			System.out.println("Click by Selenium");
		}
	}

	@Parameters("browser")
	public void TC_04_If_Else_If_Else_WebDriver_Usages(String browserName) {
		// Set condition for Webbrowser drivers.
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please run the correct Web browser");
		}
		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();
	}

	public void TC_05_If_Else_If_Else_WebDriver_Usages() {
		String pageName = "Login";

		if (pageName.equals("Login")) {
			// LoginPage loginPage = new LoginPage
			// return loginPage
		} else if (pageName.equals("Register")) {
			// RegisterPage registerPage = new RegisterPage
			// return registerPage
		} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage
			// return customerPage
		} else {
			// HomePage homePage = new HomePage
			// return homePage
		}
	}
	@Test
	public void TC_06_If_Else() {
		// Toán tử tam nguyen
		int age = 18;
		String access = (age < 18) ? "You can not access" : "Welcome to our system!";
		
		if (age <18) {
			access = "You can not access";
		} else {
			access = "Welcome to our system!";
		}
		
		System.out.println(access);
	}

}
