package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.getGlobalConstants().getProjectPath() + "/Firefoxlog.txt");
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.args", "--disable-loging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addExtensions(new File(GlobalConstants.PROJECT_PATH + "/browserExtension/UltraSurf_1_6_8_0.crx"));
			driver = new ChromeDriver(chromeOptions);
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			break;
		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("window-size-1920x1080");
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeHOptions = new ChromeOptions();
			chromeHOptions.setHeadless(true);
			chromeHOptions.addArguments("--headless");
			chromeHOptions.addArguments("window-size-1920x1080");
			driver = new ChromeDriver(chromeHOptions);
			break;
		case COCCOC:
			WebDriverManager.chromedriver().setup();
			ChromeOptions coccocOptions = new ChromeOptions();
			coccocOptions.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(coccocOptions);
			break;
		default:
			throw new RuntimeException("Browser is NOT supported");
		}

		return driver;
	}
}
