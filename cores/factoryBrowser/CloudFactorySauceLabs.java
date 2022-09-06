package factoryBrowser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class CloudFactorySauceLabs {
	private WebDriver driver;
	private String browserName;
	private String osName;

	public CloudFactorySauceLabs(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", "latest");
		capability.setCapability("name", "Run on " + osName + " | " + browserName + " latest");

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELABS_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}
}
