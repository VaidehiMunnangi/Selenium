package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	ChromeDriver driver;
	
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
	}
	
	
	public void loginFB() {
		
		driver.findElement(By.id("email")).sendKeys("vaidehimunnangi@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Vaiduchinna@2");
		driver.findElement(By.id("loginbutton")).click();
		
	}
	
	
	public void logoutFB() {
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//div[text()='Account Settings']")).click();
		////span[text()='Log Out']
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
		
	}
	
	
	public void closeBrowser() {
		
		driver.close();
	}
}
