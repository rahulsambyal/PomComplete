package webTests;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commons.BaseClass;
import commons.DataHolder;
import commons.FrameworkConstants;
import commons.TestDataInfo;
import webPages.LinkedInLoginPage;

public class OpenLinkedIn extends BaseClass {
	public static final Logger log= LoggerFactory.getLogger(OpenLinkedIn.class);
	@TestDataInfo(sheetName = "Login")
	@Test(dataProvider = "inputData", dataProviderClass = DataHolder.class)
	public void openUrl(String username, String password) {
		
		LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
		String url = FrameworkConstants.urlLinkedIn;
		WebDriver driver =getDriver();
		driver.get(url);
		linkedInLoginPage.signIn.click();
		log.info("clicked on sign in");
		Reporter.log("clicked on sign in");
		log.info("clicked on sign in");log.info("clicked on sign in");log.info("clicked on sign in");log.info("clicked on sign in");log.info("clicked on sign in");
//		linkedInLoginPage.username.sendKeys(username);
		log.info("entered username");
		Reporter.log("entered username");
		linkedInLoginPage.password.sendKeys(password);
		log.info("entered password");
		Reporter.log("entered password");
		
		linkedInLoginPage.signin.click();
		log.info("clicked on sign in");
		Reporter.log("clicked on sign in");
	}
}
