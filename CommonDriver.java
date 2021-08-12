package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {
	
	// instance of Selenium WebDriver 
	private WebDriver driver;
	
	// private var will need Setters
	private int pageLoadTimeout;
	
	// implicit wait, private var will need Setters
	private int elementDetectionTimeout; 
	
	private String currentWorkingDirectory;
	
	// method to invoke browser
	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 10; // default 10 seconds
		
		elementDetectionTimeout = 10; // default 10 seconds
		
		currentWorkingDirectory = System.getProperty("user.dir");
		
		// to check browser is chrome
		if(browserType.equalsIgnoreCase("chrome")) {
			
			// system method (key, value == relative path)
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/drivers/newchromedriver.exe");
			driver = new ChromeDriver(); // initialization
		} 
		else if(browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", currentWorkingDirectory + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver(); // initialization
		} 
		else {
			throw new Exception("Invalid Browser Type" + browserType);
		}
		
		driver.manage().window().maximize(); // maximize browser window
		
		driver.manage().deleteAllCookies();
	}

	public void navigateToUrl(String url) {
		
		// set the timeouts
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url); // to navigate to a specific page
	}
	
	// getter
	public WebDriver getDriver() {
		return driver;
	}

	// setter
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	// setter
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	// to close all browsers
	public void closeAllBrowser() {
		driver.quit();
	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	
}
