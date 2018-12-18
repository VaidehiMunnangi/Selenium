package day6;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertandFrameHandling {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver  driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		
		driver = new ChromeDriver();
		Dimension dim = new Dimension(768, 1024);
		driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
			
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("Button")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(4000);
		alert.accept();
		driver.close();
		
	}

}
