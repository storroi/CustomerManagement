package week9;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Welcome {
	

	
	 WebDriver  driver=new FirefoxDriver();

@Test
public void fire(){
	
	driver.get("https://www.google.com");
}

}
