package commons;

import java.io.IOException;
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
import org.testng.Assert;
import org.testng.Reporter;

import factoryBrowser.BrowserList;
import factoryBrowser.CloudFactoryBrowserstack;
import factoryBrowser.CloudFactoryLambda;
import factoryBrowser.CloudFactorySauceLabs;
import factoryBrowser.EnvList;
import factoryBrowser.LocalFactory;
import factoryBrowser.LocalFactoryDocker;

public class BaseTest {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ChromeOptions chromeOptions;
	FirefoxOptions firefoxOptions;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName, String url, String envName, String osName, String osVersion, String ipAddress, String portNumber) {
		switch (envName.toLowerCase()) {
		case "local":
			driver.set(new LocalFactory(browserName).createDriver());
			break;
		case "docker":
			driver.set(new LocalFactoryDocker(browserName, ipAddress, portNumber).createDriver());
			break;
		case "browserstack":
			driver.set(new CloudFactoryBrowserstack(browserName, osName, osVersion).createDriver());
			break;
		case "saucelabs":
			driver.set(new CloudFactorySauceLabs(browserName, osName).createDriver());
			break;
		case "lambda":
			driver.set(new CloudFactoryLambda(browserName, osName).createDriver());
			break;
		default:
			driver.set(new LocalFactory(browserName).createDriver());
		}

		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeout(), TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);

		return driver.get();
	}

	public WebDriver getBrowserDriverLocalByBrowserDrivers(String browserName, String urlValue) {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			if (GlobalConstants.getGlobalConstants().getOsName().startsWith("Windows")) {
				System.setProperty("webdriver.gecko.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/geckodriver.exe");
			} else {
				System.setProperty("webdriver.gecko.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/geckodriver");
			}
			driver.set(new FirefoxDriver());
			break;
		case CHROME:
			if (GlobalConstants.getGlobalConstants().getOsName().startsWith("Windows")) {
				System.setProperty("webdriver.chrome.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/chromedriver");
			}
			driver.set(new ChromeDriver());
			break;
		case EDGE:
			if (GlobalConstants.getGlobalConstants().getOsName().startsWith("Windows")) {
				System.setProperty("webdriver.edge.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/msedgedriver.exe");
			} else {
				System.setProperty("webdriver.edge.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/msedgedriver");
			}
			driver.set(new EdgeDriver());
			break;
		case OPERA:
			if (GlobalConstants.getGlobalConstants().getOsName().startsWith("Windows")) {
				System.setProperty("webdriver.opera.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/operadriver.exe");
			} else {
				System.setProperty("webdriver.opera.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "/browserDrivers/operadriver");
			}
			driver.set(new OperaDriver());
			break;
		default:
			throw new RuntimeException("Browser is NOT supported/programmed in this framework");
		}

		driver.get().get(urlValue);
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeout(), TimeUnit.SECONDS);

		return driver.get();
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

			String driverInstanceName = driver.get().toString().toLowerCase();
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
				driver.get().manage().deleteAllCookies();
				driver.get().quit();
				driver.remove();
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
		return driver.get();
	}

	protected void showBrowserConsoleLogs() {
		if (driver.toString().contains("chrome")) {
			LogEntries logs = driver.get().manage().logs().get("browser");
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
			url = GlobalConstants.getGlobalConstants().getDevGuru();
			break;
		case TESTING:
			url = GlobalConstants.getGlobalConstants().getTestingGuru();
			break;
		case STAGING:
			url = GlobalConstants.getGlobalConstants().getStagingGuru();
			break;
		case LIVE:
			url = GlobalConstants.getGlobalConstants().getProductGuru();
			break;

		default:
			throw new RuntimeException("The environment is not supported/programmed!!");
		}
		return url;
	}
}
