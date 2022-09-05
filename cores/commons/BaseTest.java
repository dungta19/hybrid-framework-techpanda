package commons;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	ChromeOptions chromeOptions;
	FirefoxOptions firefoxOptions;
	protected final Log log;

	public enum EnvList {
		DEV, TESTING, STAGING, LIVE;
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getBrowserDriverBrowserstack(String browserName, String url, String osName, String osVersion) {
		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("os", osName);
		capability.setCapability("os_version", osVersion);
		capability.setCapability("browser", browserName);
		capability.setCapability("browser_version", "latest");
		capability.setCapability("project", "TechPanda");
		capability.setCapability("name", "Run on " + osName + " | " + osVersion + " | " + browserName + " latest");

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}

	public WebDriver getBrowserDriverSaucelabs(String browserName, String url, String osName) {
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

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}

	public WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "/Firefoxlog.txt");
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.args", "--disable-loging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			chromeOptions = new ChromeOptions();
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
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("window-size-1920x1080");
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(true);
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("window-size-1920x1080");
			driver = new ChromeDriver(chromeOptions);
			break;
		case COCCOC:
			WebDriverManager.chromedriver().setup();
			chromeOptions = new ChromeOptions();
			chromeOptions.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(chromeOptions);
			break;
		default:
			throw new RuntimeException("Browser is NOT supported");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.LIVE_USER_URL);

		return driver;
	}

	public WebDriver getBrowserDriver(String browserName, String urlValue) {
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

		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		return driver;
	}

	public WebDriver getBrowserDriverByLocalDrivers(String browserName, String urlValue) {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				System.setProperty("webdriver.gecko.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/geckodriver.exe");
			} else {
				System.setProperty("webdriver.gecko.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/geckodriver");
			}
			driver = new FirefoxDriver();
			break;
		case CHROME:
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				System.setProperty("webdriver.chrome.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/chromedriver");
			}
			driver = new ChromeDriver();
			break;
		case EDGE:
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				System.setProperty("webdriver.edge.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/msedgedriver.exe");
			} else {
				System.setProperty("webdriver.edge.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/msedgedriver");
			}
			driver = new EdgeDriver();
			break;
		case OPERA:
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				System.setProperty("webdriver.opera.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/operadriver.exe");
			} else {
				System.setProperty("webdriver.opera.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/operadriver");
			}
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Browser is NOT supported/programmed in this framework");
		}

		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		return driver;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("--------------------------------PASSED--------------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("--------------------------------FAILED--------------------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("--------------------------------PASSED--------------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("--------------------------------FAILED--------------------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("--------------------------------PASSED--------------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("--------------------------------FAILED--------------------------------");
		}
		return status;
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	protected void showBrowserConsoleLogs() {
		if (driver.toString().contains("chrome")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for (LogEntry logging : logList) {
				log.info("-------------" + logging.getLevel().toString() + "-------------\n" + logging.getMessage());
			}
		}
	}

	@SuppressWarnings("unused")
	private String getEnvironment(String envName) {
		EnvList envNames = EnvList.valueOf(envName.toUpperCase());
		String url = null;
		switch (envNames) {
		case DEV:
			url = GlobalConstants.DEV_GURU;
			break;
		case TESTING:
			url = GlobalConstants.TESTING_GURU;
			break;
		case STAGING:
			url = GlobalConstants.STAGING_GURU;
			break;
		case LIVE:
			url = GlobalConstants.PRO_GURU;
			break;

		default:
			throw new RuntimeException("The environment is not supported/programmed!!");
		}
		return url;
	}
}
