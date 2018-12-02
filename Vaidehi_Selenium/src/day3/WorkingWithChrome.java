package day3;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {

	ChromeDriver driver;
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		Dimension dim = new Dimension(360, 640);
		
		driver.manage().window().setSize(dim);
		
		//driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("http://qatechhub.com");
		
	}
	
	public void printTitle()
	{
		System.out.println(driver.getTitle());
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
}
