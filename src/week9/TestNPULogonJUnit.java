package week9;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestNPULogonJUnit  {
 
	
	Logger logger=Logger.getLogger("TestNPULogonJUnit");
    WebDriver driver;
    
    @Before
    public void browserLaunch() {
    PropertyConfigurator.configure("log4j.properties");
    System.setProperty("webdriver.chrome.driver", "F://workspaceEclipse//MySelenium2//chromedriver.exe");
    driver = new ChromeDriver(); // chrome opens
    logger.info("Chrome Opened");
    }
    
    @Test
    public void testNPUCreateNewAccountJUnit() throws Exception{
    	
    	driver.get("http://www.google.com/");
    	logger.info("opened google search ");
    	
    	//id, xpath,linktext, 
    	driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("npu");
    	logger.info("searched NPU");
    	
    	 Actions actions = new Actions(driver);
 	    actions.sendKeys(Keys.ENTER).build().perform();
 	    
 		// 6. wait until the search result appears
 		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	
    
    	driver.findElement(By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont")).click();
    	logger.info("Opened Npu website");
    	Thread.sleep(5000);
    	driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
    	
    	 System.out.println(driver.getTitle()); //  print out the current page title
 		
    	 try{
    		 Assert.assertEquals(driver.getTitle(),"Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University"); // check page title is "Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University"
 		
    	 	} catch(Throwable t){
    	 		t.getMessage();
		}
    	 
    	//driver.findElement(By.linkText("Admissions")).click();
    	 //webElements menu
    	
    	driver.findElement(By.xpath(".//*[@id='block-tb-megamenu-menu-header-top-menu']/div/div/div/ul/li[2]/a")).click();
    	/*Actions action=new Actions(driver);
    	action.moveToElement(menu).perform();*/
    	driver.findElement(By.linkText("Apply Online")).click(); 
    	Thread.sleep(5000);
    	logger.info("Clicked apply online");
    	driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	driver.findElement(By.id("regcheck")).click();
    	Thread.sleep(5000);
    	logger.info("Check box clicked");
    	driver.findElement(By.linkText("Register Account")).click();
    	logger.info("clicked Register");
    	
    	driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("FirstName")).clear();
    	driver.findElement(By.id("FirstName")).sendKeys("Karthik");
    	
    	driver.findElement(By.id("LastName")).clear();
    	driver.findElement(By.id("LastName")).sendKeys("Tirunagari");
    	
    	new Select(driver.findElement(By.id("Gender"))).selectByValue("M");
    	driver.findElement(By.id("Email")).clear();
    	driver.findElement(By.id("Email")).sendKeys("karthikt90@yahoo.com");
    	driver.findElement(By.id("Password")).clear();
    	driver.findElement(By.id("Password")).sendKeys("00017972");
    	driver.findElement(By.id("ConfirmPassword")).clear();
    	driver.findElement(By.id("ConfirmPassword")).sendKeys("00017972");
    	Thread.sleep(5000);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );    
    	driver.findElement(By.xpath(".//*[@id='main']/fieldset/form[2]/input")).click();;
    	logger.info("Entered details and clicked Save");
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );    
    	Thread.sleep(2000);
    	String actual_error=driver.findElement(By.xpath(".//*[@id='main']/fieldset/div/ul/li")).getAttribute("innerHTML");
    	String expected_error="Invalid reCAPTCHA request. Missing response value.";
    	Assert.assertEquals(actual_error,expected_error);
    	System.out.println("Captha error verified!");
    	logger.info("captha not checked");
    	
    	driver.navigate().to("https://osc.npu.edu/Account/Register");
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	Thread.sleep(2000);
    	driver.navigate().to("http://www.npu.edu");
    	logger.info("Came back to NPU home page");
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	Thread.sleep(2000);
    }
    @After
    public void closeBrowser(){
    	
    	driver.close();
    	//driver.quit();
    }
    
}
