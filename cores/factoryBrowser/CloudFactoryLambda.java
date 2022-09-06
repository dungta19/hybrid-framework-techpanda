package factoryBrowser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class CloudFactoryLambda {
	private WebDriver driver;
	private String browserName;
	private String osName;

	public CloudFactoryLambda(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("browserName", browserName);
		capability.setCapability("version", "latest");
		capability.setCapability("platform", osName);
		capability.setCapability("build", "TechPanda Test");
		capability.setCapability("name", "Run on " + osName + " | " + browserName + " latest");

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

}
