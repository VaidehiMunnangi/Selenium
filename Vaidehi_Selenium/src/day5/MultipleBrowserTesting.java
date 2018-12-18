package day5;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultipleBrowserTesting {

	WebDriver driver;
	
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
		
		
		
		Dimension dim = new Dimension(768, 1024);		
		driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://qatechhub.com/");
		
	}
	
	public void printTitle() {
		
		System.out.println(driver.getTitle());
	}
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
