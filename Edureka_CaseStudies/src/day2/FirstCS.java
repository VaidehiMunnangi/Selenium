package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstCS {

	WebDriver driver;
	
	public void invokeBrowser(String browserType) {
		
		if(browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\geckodriver.exe");			
			driver = new FirefoxDriver();
		}	
		
		Dimension dim = new Dimension(768, 1024);		
		driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.edureka.co/");
		
	}
	
	public void identifyElements( ) {
		
		driver.findElement(By.className("trackButton")).sendKeys("DevOps");
		driver.findElement(By.id("homeSearchBarIcon")).click();
		driver.findElement(By.xpath("//li[@class='ga-allcourses']/a[@class='trackButton']")).click();
		driver.findElement(By.cssSelector("div[class='card giTrackElement giTrackElementHover']")).click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
