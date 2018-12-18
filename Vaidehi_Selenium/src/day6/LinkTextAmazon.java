package day6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LinkTextAmazon {

	WebDriver driver;
	List<WebElement> allLink;
	public void invokeBrowser(String d) {
		
		if(d=="firefox") {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(d== "chrome") {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(d== "ie") {
			
			System.setProperty("webdriver.ie.driver","C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	public String getLink() {
		String text = driver.findElement(By.linkText("Your Amazon.in")).getAttribute("href");
		return text;
	}
	
	public int linkCount() {
		
		allLink = driver.findElements(By.tagName("a"));
		return allLink.size();
	}
	
	public void printAllLinks() {
		
		for(WebElement link: allLink) {
			System.out.println("Link Text: " + link.getText() + " and URL: " + link.getAttribute("href"));
		}
	}
}
