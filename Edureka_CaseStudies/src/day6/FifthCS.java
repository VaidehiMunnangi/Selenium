package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FifthCS {

	WebDriver driver;

	@Parameters({ "drive" })
	@BeforeClass(alwaysRun = true)
	public void invokeBrowser(String browserType) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.edureka.co/");
	}

	@Parameters({ "uid", "pwd" })
	@Test(priority = 1000 , groups = {"login"})
	public void verifyLoginToEdureka(String userID, String password) throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='Log In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys(userID);
		driver.findElement(By.id("si_popup_passwd")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block pagesense_en_track']")).click();

	}

	@Test(priority = 2000 , groups = {"login"})
	public void browseForAllCourses() throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='dropdownMenu3']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//li[@class='ga-allcourses ga_ecom_info']//a[@class='ga_header_info trackButton'][contains(text(),'All Courses')]"))
				.click();
	}

	@Test(priority = 3000 , groups = {"login"})
	public void logout() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='dropdown-toggle trackButton']")).click();
		driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu user-menu profile-xs hidden-sm hidden-xs']//a[@class='trackButton'][contains(text(),'Log Out')]"))
				.click();
	}
	
	@Parameters({"uid" , "num"})
	@Test(priority = 4000, groups = {"validation"})
	public void signUp(String userID,String number) throws Exception {		
		
			driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='sg_popup_email']")).sendKeys(userID);
			driver.findElement(By.id("sg_popup_phone_no")).sendKeys(number);
			driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block signup-new-submit']")).click();
			
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			String expectedTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
			if((driver.getTitle()).equals(expectedTitle))  
				throw new Exception("UserID already exists");
			
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
