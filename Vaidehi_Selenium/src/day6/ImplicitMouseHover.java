package day6;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitMouseHover {
	
	ChromeDriver driver;
	
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VAIDEHI\\\\eclipse-workspace\\\\lib\\\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
	}

	public void mouseHover() {
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions action = new Actions(driver);
		action.moveToElement(electronics).click().build().perform();
		
		//Explicit wait
		waitTillElementVisible(10, By.xpath("(//a[@title=\"Samsung\"])[1]"));
		
		//Fluent wait
		fluentWait(20,10, By.xpath("(//a[text()='Samsung'])[1]"));

		WebElement samsung = driver.findElement(By.xpath("(//a[@title='Samsung'])[1]"));
		action.moveToElement(samsung).click().build().perform();
		
		System.out.println(driver.getTitle());
		//driver.close();
		
	}

	private void fluentWait(int i, int j, By xpath) {
		// TODO Auto-generated method stub
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(i)).pollingEvery(Duration.ofSeconds(j))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		
	}

	private void waitTillElementVisible(int i, By xpath) {
		// TODO Auto-generated method stub
		
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	}
}
