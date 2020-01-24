package commons;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected WebDriver driver = null;

	public BaseClass(WebDriver driver) {
		this.driver= driver;
	}
	
	public BaseClass() {
		
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String param) {
		driver = DriverManager.getDriver(param, driver);
		driver.manage().window().maximize();
		this.driver= driver;
	}

	public WebDriver getDriver() {

		return (this.driver);
	}

	@AfterMethod
	public void TearDown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			GenericMethods.takeScreenShotForFailedCases(driver,result.getName());
		}
		driver.quit();
	}
}
