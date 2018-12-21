package day4;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ThirdCS {
	
	static ChromeDriver driver;

	public static void main(String args[]) {
		
		invokeBrowser();
		closeBrowser();
	}

	public static void invokeBrowser() {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		/* Launch the Browser */
		driver.navigate().to("https://www.goindigo.in/?linkNav=home_header");

		/* Select one way as input */
		driver.findElement(By.cssSelector("#oneWayTrip")).click();

		/* Details of Travel */
		driver.findElement(By.xpath("//input[@placeholder='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("(//div[text()='Bengaluru, India'])[1]")).click();

		driver.findElement(By.xpath("//input[@placeholder='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Lucknow");
		driver.findElement(By.xpath("(//div[text()='Lucknow, India'])[1]")).click();

		/* Selecting Departure Date */
		driver.findElement(By.xpath("//input[@class='form-control or-depart igInitCalendar focus']")).click();
		driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'27')]"))
				.click();

		/* Selecting Passenger field */
		driver.findElement(By.xpath("//input[@name='passenger']")).click();
		WebElement adult = driver.findElement(By.xpath(
				"//div[@class='passenger-dropdown pax-selection-row']//li[@class='adult-pax-list']//button[@title='Up']"));
		for (int i = 1; i <= 3; i++) {
			adult.click();
		}

		WebElement child = driver.findElement(By.xpath(
				"//div[@class='passenger-dropdown pax-selection-row']//li[@class='child-pax-list']//button[@title='Up']"));
		for (int i = 0; i < 2; i++) {
			child.click();
		}

		/* Search Flights */
		driver.findElement(By.xpath("//div[@class=\"row justify-content-around ie-justify-pass-cur\"]")).click();
		driver.findElement(
				By.xpath("//button[@class=\"btn btn-primary block bold ig-search-btn ig-common-cta addLoader\"]"))
				.click();

		/* Wait for page to load */
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}

		public static void closeBrowser() {
			/* Closing browser */
			driver.quit();
			
		
		}

}
