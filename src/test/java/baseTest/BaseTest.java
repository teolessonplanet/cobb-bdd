package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import util.BrowserName;

public class BaseTest {
	private final static String BROWSER_SYSTEM_VAR = "browser";
	private final static String DRIVER_VERSION = "driverversion";
	private final static String HEADLESS_SYSTEM_VAR = "headless";
	private final static String FIREFOX_PROFILE = "ffprof";
	private final static String IP_WHITELISTED_SYSTEM_VAR = "ipwhitelisted";
	private final static String SERVER_URL_SYSTEM_VAR = "server";

	public static WebDriver driver;
	public Properties configProp;
	private String driverVersion = "";
	private boolean headlessBrowser = false;
	private boolean firefoxDefaultProfile = false;
	private boolean ip_whitelisted = false;
	private String serverUrl = util.Data.STAGING_URL;

	public void getDriverFromInternet(String browser) {
		if (StringUtils.isBlank(browser)) {
			throw new IllegalArgumentException("Browser name is not set in VM options. "
					+ "Please make sure you're setting the <browser> value before starting the tests "
					+ "-- https://www.screencast.com/t/CGYCEL6bc3U --");
		}

		if (StringUtils.isNoneEmpty(System.getProperty(DRIVER_VERSION))) {
			driverVersion = System.getProperty(DRIVER_VERSION);
		}

		if (browser.equals(BrowserName.CHROME.getName())) {
			if (!driverVersion.isEmpty()) {
				WebDriverManager.chromedriver().driverVersion(driverVersion);
			}
			WebDriverManager.chromedriver().setup();
		}

		if (browser.equals(BrowserName.FIREFOX.getName())) {
			if (!driverVersion.isEmpty()) {
				WebDriverManager.firefoxdriver().driverVersion(driverVersion);
			}
			WebDriverManager.firefoxdriver().setup();
		}

		if (browser.equals(BrowserName.EDGE.getName())) {
			if (!driverVersion.isEmpty()) {
				WebDriverManager.edgedriver().driverVersion(driverVersion);
			}
			WebDriverManager.edgedriver().setup();
		}
	}

	public void setUp() {

		try {
			configProp = new Properties();
			FileInputStream configProFile = new FileInputStream("config.properties");
			configProp.load(configProFile);

			String browser = configProp.getProperty("browser");
			headlessBrowser = Boolean.parseBoolean(configProp.getProperty("headless_system_var"));
			ip_whitelisted = Boolean.parseBoolean(configProp.getProperty("ip_whitelisted"));
			try {
				if (!StringUtils.isBlank(System.getProperty(BROWSER_SYSTEM_VAR))) {
					browser = System.getProperty(BROWSER_SYSTEM_VAR).toLowerCase();
				}
				if (System.getProperty(HEADLESS_SYSTEM_VAR).equals("true")) {
					headlessBrowser = true;
				}
				if (System.getProperty(FIREFOX_PROFILE).equals("true")) {
					firefoxDefaultProfile = true;
				}
				if (System.getProperty(IP_WHITELISTED_SYSTEM_VAR).equals("false")) {
					ip_whitelisted = false;
				}
				if (System.getProperty(SERVER_URL_SYSTEM_VAR).equals("feature")) {
					serverUrl = util.Data.FEATURE_URL;
				}
			} catch (SecurityException | NullPointerException | IllegalArgumentException e) {

			}

			if (driver == null) {
				if (browser.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					options.setExperimentalOption("useAutomationExtension", false);
					options.addArguments("disable-infobars");

					if (headlessBrowser) {
						options.addArguments("headless");
						options.addArguments("window-size=1920x2160");
					}
					driver = new ChromeDriver(options);
				}

				else if (browser.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions firefoxOptions = new FirefoxOptions();

					if (firefoxDefaultProfile) {
						ProfilesIni profile = new ProfilesIni();
						FirefoxProfile firefoxProfile = profile.getProfile("default");
						firefoxOptions.setProfile(firefoxProfile);
					}

					if (headlessBrowser) {
						firefoxOptions.addArguments("--headless");
					}

					driver = new FirefoxDriver(firefoxOptions);
					if (headlessBrowser) {
						driver.manage().window().setSize(new Dimension(1920, 2160));
					}
				} else if (browser.equals(BrowserName.EDGE.getName())) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				} else {
					throw new IllegalArgumentException("Browser name is incorrectly set in VM options");
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (!ip_whitelisted) {
					driver.get(serverUrl.replace("://", "://demo:hqu5duYLqbyi6@"));
				} else {
					driver.get(serverUrl);
				}
			}

		} catch (IOException ex) {

		}
	//	return driver;
	}

	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
