package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case_Exercises {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Parameters("browser")

	public void TC_01_Switch_Case(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		driver.quit();
	}

	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Please input a correct browser name!");
			break;
		}
		return driver;
	}

	public void TC_02() {
		System.out.print(" Month = ");
		int a = scanner.nextInt();

		switch (a) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng " + a + " có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng " + a + " có 28 hoặc 29 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng " + a + " có 30 ngày");
		default:
			System.out.println("Error, vui lòng nhập đúng số tháng!");
			break;
		}

	}

	public void TC_03() {
		System.out.print(" Month = ");
		int a = scanner.nextInt();
		
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		default:
			System.out.println("Your input number is not fuctioned!");
			break;
		}
	}
	
	@Test
	public void TC_04() {
		int a = scanner.nextInt();
		String math = scanner.next();
		int b = scanner.nextInt();
		
		switch (math) {
		case "+":
			System.out.println("= " + (a + b));
			break;
		case "-":
			System.out.println("= " + (a - b));
			break;
		case "*":
			System.out.println("= " + (a * b));
			break;
		case "/":
			System.out.println("= " + (a / b));
			break;
		case "%":
			System.out.println("= " + (a % b));
			break;
		default:
			System.out.println("Oops... there are something wrong! Please check!");
			break;
		}
	}
	
	
}
