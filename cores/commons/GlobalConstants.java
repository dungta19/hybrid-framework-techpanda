package commons;

import java.io.File;

public class GlobalConstants {
	// System information
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");

	// Application information USER
	public static final String DEV_USER_URL = "http://dev.techpanda.org/";
	public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
	public static final String LIVE_USER_URL = "http://live.techpanda.org/";

	// Application information ADMIN
	public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin";
	public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
	public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";

	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";

	// Wait Timeout information
	public static final long SHORT_TIMEOUT = 10;
	public static final long LONG_TIMEOUT = 30;

	// Download/ Upload files
	public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles/";
	public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGFailureScreenShots" + File.separator;

	// Retry Case failed
	public static final int RETRY_NUMBER = 3;

	// Browser Logs
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
	public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";

	// HTML Report Folder
	public static final String REPORTNG_PATH = PROJECT_PATH + "/htmlReprtNG/";
	public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
	public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";

	// SauceLab Page
	public static final String SL_USER_NAME_TEXT_BOX = "id=user-name";
	public static final String SL_PASSWORD_TEXT_BOX = "id=password";
	public static final String SL_LOGIN_BUTTON = "id=login-button";

	// Guru99 Page
	public static final String DEV_GURU = "https://demo.guru99.com/v1/";
	public static final String TESTING_GURU = "https://demo.guru99.com/v2/";
	public static final String STAGING_GURU = "https://demo.guru99.com/v3/";
	public static final String PRO_GURU = "https://demo.guru99.com/v4/";

	/* Browserstack Cloud testing */
	public static final String BROWSER_USERNAME = "dungta_Rly675";
	public static final String BROWSER_ACCESS_KEY = "CaWpw98gYZrbAqvoPhdx";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

	/* Saucelabs Cloud testing */
	public static final String SAUCELABS_USERNAME = "oauth-ttdung1901-89210";
	public static final String SAUCELABS_ACCESS_KEY = "b3fed453-ae68-48c2-81c8-5862cdaddcf3";
	public static final String SAUCELABS_URL = "https://" + SAUCELABS_USERNAME + ":" + SAUCELABS_ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
}
