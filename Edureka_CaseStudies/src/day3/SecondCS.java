package day3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SecondCS {
	
	static ChromeDriver driver;
	
	public static void main(String args[]) {
		
		invokeBrowser();
		courseSearch();
		closeBrowser();
		
	}
	
	public static void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.edureka.co/");
	}

	public static void courseSearch() {
		
		/* Search for a course */
		driver.findElement(By.className("trackButton")).sendKeys("DevOps");
		driver.findElement(By.id("homeSearchBarIcon")).click();	
		
		/* Page load time */
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/* Handling Dynamic elements */		
		driver.findElement(By.cssSelector("[class='closeFestBar ga_learningPath_ajax']")).click();
		
	}
	public static void closeBrowser() {
		
		driver.quit();
	}
}
