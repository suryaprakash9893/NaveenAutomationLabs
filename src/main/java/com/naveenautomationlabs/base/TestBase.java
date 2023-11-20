package com.naveenautomationlabs.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.Utils.WebdriverEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	private final Browsers BROWSER_SELECTION = Browsers.CHROME;
	private final String BASE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

	public static Logger logger;
	public WebdriverEvent event;
	public EventFiringWebDriver e_driver;
	private static final boolean RUN_ON_GRID = true;

	@BeforeClass
	public void loggerSetup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void initialisation() throws MalformedURLException {

		if (RUN_ON_GRID) {

			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.33:4444/"), getOptions());
			} catch (MalformedURLException e) {
				e.printStackTrace();

			}
		} else {
			switch (BROWSER_SELECTION) {
			case CHROME:
				driver = WebDriverManager.chromedriver().create();
				break;

			case FIREFOX:
				driver = WebDriverManager.firefoxdriver().create();
				break;

			case EDGE:
				driver = WebDriverManager.edgedriver().create();
				break;

			default:
				throw new IllegalArgumentException();
			}
		}

		// Wrap the instance
		e_driver = new EventFiringWebDriver(driver);

		// Events to be captured.
		event = new WebdriverEvent();
		e_driver.register(event);

		// Assigning back the value to Webdriver.
		driver = e_driver;

		driver.manage().window().maximize();
		driver.get(BASE_URL);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(BROWSER_SELECTION);
	}

	public void tearDown() {
		try {
			driver.quit();
		} finally {
			driver.quit();
		}
	}
}
