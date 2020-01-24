package webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commons.BaseClass;
import commons.DataHolder;
import commons.FrameworkConstants;
import commons.GenericMethods;
import commons.TestDataInfo;
import webPages.HomePage;

public class OpenWingfy extends BaseClass {
	public static final Logger log = LoggerFactory.getLogger(OpenWingfy.class);

	@TestDataInfo(sheetName = "Login")
	@Test(dataProvider = "inputData", dataProviderClass = DataHolder.class)
	public void openUrl(String username, String password) {

		String url = FrameworkConstants.urlWingfy;
		log.info("Url is: " + url);
		WebDriver driver = getDriver();
		driver.get(url);
		Reporter.log(url);
		Reporter.log("Logged in");
		HomePage homePage = new HomePage(driver);
		GenericMethods.waitForElementToLoad(driver, homePage.heatMaps);
		Reporter.log("HeatMap displayed");

	}
}
