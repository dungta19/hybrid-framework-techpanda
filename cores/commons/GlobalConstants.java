package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;

	private GlobalConstants() {

	}

	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}

	private final String projectPath = System.getProperty("user.dir");
	private final String osName = System.getProperty("os.name");
	private final String javaVersion = System.getProperty("java.version");
	private final String devUserUrl = "http://dev.techpanda.org/";
	private final String stagingUserUrl = "http://staging.techpanda.org/";
	private final String liveUserUrl = "http://live.techpanda.org/";
	private final String devAdminUrl = "http://dev.techpanda.org/index.php/backendlogin";
	private final String stagingAdminUrl = "http://staging.techpanda.org/index.php/backendlogin";
	private final String liveAdminUrl = "http://live.techpanda.org/index.php/backendlogin";
	private final String adminUsername = "user01";
	private final String adminPassword = "guru99com";
	private final long shortTimeout = 10;
	private final long longTimeout = 30;
	private final String uploadPath = projectPath + "/uploadFiles/";
	private final String downloadPath = projectPath + "/downloadFiles/";
	private final String reportNGScreenshoot = projectPath + File.separator + "ReportNGFailureScreenShots" + File.separator;
	private final int RETRY_NUMBER = 3;
	private final String browserLogPath = projectPath + "/browserLogs/";
	private final String browserExtensionPath = projectPath + "/browserExtensions/";
	private final String reportNGPath = projectPath + "/htmlReprtNG/";
	private final String extentPath = projectPath + "/htmlExtent/";
	private final String allurePath = projectPath + "/htmlAllure/";
	private final String saucelabUserNameTextbox = "id=user-name";
	private final String saucelabPasswordTextbox = "id=password";
	private final String saucelabLoginButton = "id=login-button";
	private final String devGuru = "https://demo.guru99.com/v1/";
	private final String testingGuru = "https://demo.guru99.com/v2/";
	private final String stagingGuru = "https://demo.guru99.com/v3/";
	private final String productGuru = "https://demo.guru99.com/v4/";
	private final String browserUserName = "dungta_Rly675";
	private final String browserAccessKey = "CaWpw98gYZrbAqvoPhdx";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAccessKey + "@hub-cloud.browserstack.com/wd/hub";
	private final String saucelabsUserName = "oauth-ttdung1901-89210";
	private final String saucelabsAccessKey = "b3fed453-ae68-48c2-81c8-5862cdaddcf3";
	private final String saucelabsUrl = "https://" + saucelabsUserName + ":" + saucelabsAccessKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	private final String lamdaUsername = "ttdung1901";
	private final String lamdaAcessKey = "SaU0K3KdZqmArCWGQqV4AcfVtwoh442JIDU859yoNpl0nhDjpR";
	private final String lamdaUrl = "https://" + lamdaUsername + ":" + lamdaAcessKey + "@hub.lambdatest.com/wd/hub";
}
