package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99Project {
	
	
	WebDriver driver;

	@Parameters({"drive"})
	@BeforeClass
	public void invokeBrowser(String browserType) {

		if(browserType.equals("ie"))  {
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		else if(browserType.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if(browserType.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\geckodriver.exe");			
			driver = new FirefoxDriver();
		}
		
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.get("http://demo.guru99.com/v4");
	}

	@Test(priority = 0)
	public void verifyTitleOfThePage() {
		String expectedTitle = "Guru99 Bank Home Page";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Parameters({"uid","pwd"})
	@Test(priority = 1000)
	public void verifyLoginToGuru99Application(String userID,String password) {
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
