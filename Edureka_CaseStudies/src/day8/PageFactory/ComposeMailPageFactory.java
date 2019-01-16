package day8.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeMailPageFactory {

	WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement composeMail;
	@FindBy(xpath="//textarea[@id=':q2']")
	private WebElement sendTo; 
	@FindBy(xpath="//input[@id=':pk']")
	private WebElement subject; 
	@FindBy(xpath="//div[@id=':qp']")
	private WebElement content;
	@FindBy(xpath="//div[@id=':pa']")
	private WebElement sendMail;
	@CacheLookup
	@FindBy(xpath="//span[@class='gb_cb gbii']")
	private WebElement logoutv;
	@CacheLookup
	@FindBy(xpath="//a[@id='gb_71']")
	private WebElement logout;
	
	
	public ComposeMailPageFactory(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
	}
	
	public void sendMail(String to,String sub,String text) {
		
		composeMail.click();
		sendTo.sendKeys(to);
		subject.sendKeys(sub);
		content.sendKeys(text);
		sendMail.click();
	}
	
	public void logOut() throws InterruptedException {
		
		Thread.sleep(500);
		logoutv.click();
		Thread.sleep(200);
		logout.click();
		
	}

}
