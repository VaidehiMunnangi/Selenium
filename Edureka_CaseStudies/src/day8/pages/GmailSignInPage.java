package day8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailSignInPage {

	WebDriver driver;
	private WebElement signIn;
	private WebElement next;
	private WebElement password;
	private WebElement login;

	public GmailSignInPage(WebDriver driver) {

		this.driver = driver;

		signIn = driver.findElement(By.xpath("//input[@id='identifierId']"));
		next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		password = driver.findElement(By.xpath("//input[@name='password']"));
		login = driver.findElement(By.xpath("//div[@id='passwordNext']//content[@class='CwaK9']"));
		

	}

	public void loginGmail(String id, String pwd) {

		signIn.sendKeys(id);
		next.click();
		password.sendKeys(pwd);
		login.click();
	}
}
