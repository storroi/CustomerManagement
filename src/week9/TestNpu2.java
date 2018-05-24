package week9;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestNpu2 {
	
	
	

	Logger logger = Logger.getLogger("TestNpu2");
	WebDriver driver;

	@Before
	public void browserLaunch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Users//Karthik//Documents//EGDownloads//chromedriver_win32//chromedriver.exe");
		
		//System.setProperty("webdriver.gecko.driver", "C://Users//Karthik//Documents//EGDownloads//geckodriver-v0.15.0-win64//geckodriver.exe");
		PropertyConfigurator.configure("log4j.properties");
		driver = new ChromeDriver();
		logger.info("firefox Opened");
		//driver.get("http://www.google.com");
		Thread.sleep(5000);
	}

	@Test
	public void testNPUCreateNewAccountJUnit() throws Exception {
		//logger.debug("error");
		driver.get("http://www.google.com/");
    	logger.info("opened google search ");
    	driver.manage().window().maximize();
	}

	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
