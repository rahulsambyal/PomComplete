package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	public static WebDriver getDriver(String browser, WebDriver driver) {
		
		switch(browser){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		return driver;
	}

	
}
