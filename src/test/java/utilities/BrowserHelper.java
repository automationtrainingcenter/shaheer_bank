package utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BrowserHelper {
	 protected WebDriver driver;
	static ExtentHtmlReporter reporter;
	static ExtentReports reports;
	static ExtentTest testTag, test;

	/*
	 * this method accepts folder name which is a folder in your project root folder and 
	 * driver name, returns path of the driver executable file irrespective of the OS
	 */
	private String getDriverPath(String folderName, String driverName) {
		String os = System.getProperty("os.name").toLowerCase();
		String rootFolder = System.getProperty("user.dir");
		String driverPath;
		if (os.contains("win")) {
			driverPath = rootFolder + File.separator + folderName + File.separator + driverName + ".exe";
		} else {
			driverPath = rootFolder + File.separator + folderName + File.separator + driverName;
		}
		return driverPath;
	}


	// launch browser
	public void openBrowser(String browserName, String url) {
		browserName = browserName.toLowerCase();
		if (browserName.equals("chrome")) {
//			setSystemProperty("chromedriver", "drivers");
			System.setProperty("webdriver.chrome.driver", getDriverPath("drivers", "chromedriver"));
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", getDriverPath("drivers", "geckodriver"));
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("browser name must be either chrome or firefox");
		}
		// create an object of MyListener class
		MyListener listener = new MyListener();
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		edriver.register(listener);
		driver = edriver;

		driver.get(url);
		driver.manage().window().maximize();
	}

	public void openBrowser(String browserName, String url, String os, String nodeURL){
		DesiredCapabilities caps = new DesiredCapabilities();
		if(os.equalsIgnoreCase("windows")){
			caps.setPlatform(Platform.WINDOWS);
		}
		if(os.equalsIgnoreCase("linux")){
			caps.setPlatform(Platform.LINUX);
		}
		if(browserName.equalsIgnoreCase("chrome")){
			caps = DesiredCapabilities.chrome();
		}
		if(browserName.equalsIgnoreCase("firefox")){
			caps = DesiredCapabilities.firefox();
		}
		try {
			driver = new RemoteWebDriver(new URL(nodeURL), caps);
			// create an object of MyListener class
			MyListener listener = new MyListener();
			EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
			edriver.register(listener);
			driver = edriver;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	// close browser
	public void closeBrowser() {
		if(driver.getWindowHandles().size()>1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
