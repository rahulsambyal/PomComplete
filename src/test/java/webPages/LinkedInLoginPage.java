package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BaseClass;

public class LinkedInLoginPage extends BaseClass{

	public LinkedInLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sign in']")
	public WebElement signIn;
	@FindBy(xpath="//label[contains(text(),'Email')]")
	public WebElement username;
	@FindBy(xpath="//label[contains(text(),'Password')]")
	public WebElement password;
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	public WebElement signin;
	
	
}
