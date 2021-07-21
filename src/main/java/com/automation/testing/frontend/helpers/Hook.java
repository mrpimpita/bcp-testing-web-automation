package com.automation.testing.frontend.helpers;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Hook {

	private static final long DELAY = 10;

	private static final String KEY_CHROME = "webdriver.chrome.driver";

	private static final String DRIVER_CHROME = System.getProperty("user.dir") + "/src/main/resources/driver/chrome/chromedriver.exe";

	private static WebDriver driver;

	@Before
	public void setUpBrowser() {

		try {

			System.setProperty(KEY_CHROME, DRIVER_CHROME);

			System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments(
					"--verbose",
					"--ignore-certificate-errors",
					"--allow-running-insecure-content",
					"--allow-insecure-localhost",
					"--no-sandbox",
					"--disable-gpu",
					"enable-automation",
					"--disable-infobars",
					"--disable-dev-shm-usage",
					"--disable-browser-side-navigation"
			);

			driver = new ChromeDriver(chromeOptions);

			getDriver().manage().window().maximize();

			getDriver().manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);

			System.out.println("***********************************************");
			System.out.println("******    S T A R T   B R O W S E R    ********");
			System.out.println("***********************************************");

		}catch (Throwable t){

			System.out.println("setUpBrowser()"+t.getMessage());

			throw t;

		}

	}


	public static WebDriver getDriver() {
		return driver;
	}


	@After
	public void tearDown() throws IOException { getDriver().quit(); }

}
