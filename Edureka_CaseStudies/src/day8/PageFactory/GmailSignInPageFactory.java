package day8.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSignInPageFactory {
	
	WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//input[@id='identifierId']")
	private WebElement signIn;
	@CacheLookup
	@FindBy(xpath="//span[contains(text(),'Next')]")
	private WebElement next;
	@CacheLookup
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@CacheLookup
	@FindBy(xpath="//div[@id='passwordNext']//content[@class='CwaK9']")
	private WebElement login;

	public GmailSignInPageFactory(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void loginGmail(String id, String pwd) {

		signIn.sendKeys(id);
		next.click();
		password.sendKeys(pwd);
		login.click();
	}
}
