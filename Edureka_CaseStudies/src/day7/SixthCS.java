package day7;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class SixthCS {

	static ChromeDriver driver;

	public static void main(String args[]) throws InterruptedException, IOException {

		invokeBrowser();
		orderBook();
		closeBrowser();
	}

	public static void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/* Launch the Browser */
		driver.navigate().to("https://www.flipkart.com/");

	}

	public static void orderBook() throws InterruptedException, IOException {

		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		Thread.sleep(200);
		/* Search for selenium Book */
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
				.sendKeys("Selenium");
		driver.findElement(By.xpath("//*[@width='20']")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//div[contains(@data-id,'9789332526297')]//div[contains(@class,'_3liAhj _1R0K0g')]//a[contains(@class,'Zhf2z-')]//div//div//img[contains(@class,'_30XEf0')]"))
				.click();
		
		/* Switch to new window */
		String childWindow = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(childWindow);
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* PinCode check */
		driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("522007");
		driver.findElement(By.xpath("//span[@class='_2aK_gu']")).click();
		
		Thread.sleep(500);
		String duration = driver.findElement(By.xpath("//div[@class='_29Zp1s']")).getText();
		System.out.println("Selenium Book from flipkart to 522007: " + duration);
		
		/* Add to the cart */
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* Place Order */
		driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
		
		/* Giving Random email id and password */
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'CONTINUE')]")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mnbvcxz");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/* Capture error message */
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println("Error: " + driver.findElement(By.xpath("//span[contains(text(),'Your username or password is incorrect')]")).getText());
		
		/* Take Screenshot */		
		File screenshot = ((TakesScreenshot) driver)
	            .getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File("D:\\Selenium\\img.jpg"));
		
	}

	private static void closeBrowser() {
		driver.quit();

	}
}