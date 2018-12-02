package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99Project {
	
	ChromeDriver driver;
	
	public void invokeBrowser()
	{	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");	
	driver = new ChromeDriver();	
	driver.manage().window().maximize();	
	driver.manage().deleteAllCookies();	
	driver.get("http://demo.guru99.com/V4/");
	}
	
	public void loginGuru(String userID,String password) {
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
	}
	
	public void newCustomer() {
		
		driver.findElement(By.linkText("New Customer")).click();
		driver.findElement(By.name("name")).sendKeys("Vaidehi");
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.name("dob")).sendKeys("27/11/1998");
		driver.findElement(By.name("addr")).sendKeys("Gilles Crescent \n HillCrest");
		driver.findElement(By.name("city")).sendKeys("Adelaide");
		driver.findElement(By.name("state")).sendKeys("SA");
		driver.findElement(By.name("pinno")).sendKeys("5086");
		driver.findElement(By.name("telephoneno")).sendKeys("156987536");
		
		String emailId = "aa" + System.currentTimeMillis() + "@gmail.com";
		
		driver.findElement(By.name("emailid")).sendKeys(emailId);
		driver.findElement(By.name("password")).sendKeys("jhcdcd");
		driver.findElement(By.name("sub")).click();		
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
