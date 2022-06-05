package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			break;

		default:
			throw new RuntimeException("Browser is NOT supported");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");

		return driver;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
}
