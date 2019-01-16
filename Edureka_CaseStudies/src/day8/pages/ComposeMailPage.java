package day8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeMailPage {

	WebDriver driver;
	private WebElement composeMail;
	private WebElement sendTo;
	private WebElement subject;
	private WebElement content;
	private WebElement sendMail;
	private WebElement logoutv;
	private WebElement logout;

	public ComposeMailPage(WebDriver driver) {

		this.driver = driver;

		composeMail = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
		sendTo = driver.findElement(By.xpath("//textarea[@id=':nj']"));
		subject = driver.findElement(By.xpath("//input[@id=':o1']"));
		content = driver.findElement(By.xpath("//div[@id=':mw']"));
		sendMail = driver.findElement(By.xpath("//div[@id=':ob']"));
		logoutv = driver.findElement(By.xpath("//span[@class='gb_cb gbii']"));
		logout = driver.findElement(By.xpath("//a[@id='gb_71']"));

	}

	public void sendMail(String to, String sub, String text) {

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
