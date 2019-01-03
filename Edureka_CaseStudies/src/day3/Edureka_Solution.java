package day3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Edureka_Solution {

	static WebDriver driver;
	private static String url = "https://www.edureka.co/";

	// Setup Driver
	@BeforeClass
	public static void setupTest() {
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.navigate().to(url);
	System.out.println("Launched the chrome browser with the given url");
	driver.manage().window().maximize();
	}

	@Test
	public void browserSleepExampleTest() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
	js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");
	driver.findElement(By.id("homeSearchBar")).sendKeys("Selenium");
	driver.findElement(By.id("homeSearchBar")).sendKeys(Keys.ENTER);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course-box-333\"]")));
	driver.findElement(By.xpath("//*[@id=\"course-box-333\"]")).click();
	try {
	Thread.sleep(10000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	String title = driver.getTitle();
	if(title.contains("Selenium 3.0 WebDriver Online Training")){
	System.out.println("The selenium course page opened");
	}
	else{
	System.out.println("Unable to open the selenium course page");
	}
	driver.navigate().back();
	WebDriverWait waitElement = new WebDriverWait(driver,20);
	waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course-box-333\"]")));
	System.out.println("Clicking on All Courses");
	driver.findElement(By.id("load_allcourses")).click();
	FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
	.withTimeout(30, TimeUnit.SECONDS)
	.pollingEvery(5, TimeUnit.SECONDS)
	.ignoring(NoSuchElementException.class);
	WebElement element = fluentwait.until(new Function<WebDriver, WebElement>() {
	public WebElement apply(WebDriver driver) {
	WebElement element = driver.findElement(By.xpath("//a[text()=\"View Details\"]"));
	String getTextOnPage = element.getText();
	System.out.println(getTextOnPage);
	if(getTextOnPage.equals("View Details")){
		System.out.println("All the courses loaded successfully");
		return element;
		}else{
		System.out.println("FluentWait Failed");
		return null;
		}
		}
		});
		}
		//Close Driver
		@AfterClass
		public static void quitDriver() {
		System.out.println("Closing the Browser");
		driver.quit();
		}
	}
	
	