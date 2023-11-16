package com.naveenautomationlabs.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.Utils.WebdriverEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	private final String BROWSER_SELECTION = "CHROME";
	private final String BASE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

	public static Logger logger;
	public WebdriverEvent event;
	public EventFiringWebDriver e_driver;

	@BeforeClass
	public void loggerSetup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void initialisation() {

		switch (BROWSER_SELECTION) {
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;

		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;

		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;

		default:
			throw new IllegalArgumentException();
		}

		// Wrap the instance
		e_driver = new EventFiringWebDriver(driver);

		// Events to be captured.
		event = new WebdriverEvent();
		e_driver.register(event);

		// Assigning back the value to webdriver.
		driver = e_driver;

		driver.manage().window().maximize();
		driver.get(BASE_URL);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	public void tearDown() {
		driver.close();
	}

}
