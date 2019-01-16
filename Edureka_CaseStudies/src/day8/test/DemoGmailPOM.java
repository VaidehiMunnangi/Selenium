package day8.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import day8.pages.ComposeMailPage;
import day8.pages.GmailSignInPage;

public class DemoGmailPOM {

	GmailSignInPage signInPage;
	ComposeMailPage composeMail;
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com/");
	}
	
	@Test(priority = 0)
	public void signIn() throws Exception {
		
		signInPage = new GmailSignInPage(driver);
		signInPage.loginGmail("vaidehimunnangi@gmail.com", "Vaiduchinna@2");
		
	}
	

	@Test(priority = 1000)
	public void composeMail() throws Exception {
		composeMail = new ComposeMailPage(driver);
		composeMail.sendMail("vaidehimunnangi@gmail.com", "Hi", "Welcome to POM");
		composeMail.logOut();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
