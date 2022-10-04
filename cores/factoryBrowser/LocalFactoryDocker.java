package factoryBrowser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactoryDocker {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;

	public LocalFactoryDocker(String browserName, String ipAddress, String portNumber) {
		super();
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;

		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);

			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.merge(capability);
			break;

		case CHROME:
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);

			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.merge(capability);
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			capability = DesiredCapabilities.edge();
			capability.setBrowserName("edge");
			capability.setPlatform(Platform.ANY);
			capability.setJavascriptEnabled(true);
			break;

		case SAFARI:
			WebDriverManager.safaridriver().setup();
			capability = DesiredCapabilities.safari();
			capability.setBrowserName("safari");
			capability.setPlatform(Platform.MAC);
			capability.setJavascriptEnabled(true);
			break;

		case IE:
			WebDriverManager.iedriver().setup();
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internetexplorer");
			capability.setPlatform(Platform.ANY);
			capability.setJavascriptEnabled(true);
			break;

		default:
			throw new RuntimeException("The input browser is not supported!");
		}

		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

}
