package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dim = new Dimension(768, 1024);
		driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		
		String parentWindow = driver.getWindowHandle();		
		
		driver.switchTo().frame("iframeResult");		
		driver.findElement(By.tagName("button")).click();
		
		String childWindow = driver.getWindowHandles().toArray()[1].toString();
		
		driver.switchTo().window(childWindow);
		System.out.println("Child window title: "+ driver.getTitle());
		System.out.println("Child window handle: "+ childWindow + "\n");
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
		System.out.println("Parent Window Title: " + driver.getTitle());
		System.out.println("Parent Window Handle: " + parentWindow);
		
		Thread.sleep(2000);
		driver.close();
		
	}

}
