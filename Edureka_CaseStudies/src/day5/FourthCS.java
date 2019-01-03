package day5;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourthCS {

	static ChromeDriver driver;

	public static void main(String args[]) throws InterruptedException, IOException {

		invokeBrowser();
		login();
		editDetails();
		closeBrowser();
	}

	private static void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.navigate().to("https://www.edureka.co/");

	}

	private static void login() throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='Log In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("vaidehimunnangi@gmail.com");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("Vaiduchinna@2");
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block pagesense_en_track']")).click();

	}

	private static void editDetails() throws InterruptedException, IOException {

		/* Navigate to MyProfile */

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='dropdown-toggle trackButton']/span[@class='webinar-profile-name']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ul[@class=\"dropdown-menu user-menu profile-xs hidden-sm hidden-xs\"]/li/a[text()='My Profile']"))
				.click();

		/* Update Personal and Professional details */

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='personal-details']//i[@class='icon-pr-edit']")).click();

		/* Updating Name */
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.click();
		name.clear();
		name.sendKeys("Boyapati");

		/* Updating role */
		WebElement role = driver.findElement(By.xpath("//input[@name='currentrole']"));
		role.click();
		role.clear();
		Thread.sleep(1000);
		explicitWait(driver);
		driver.findElement(By.xpath("//a[contains(text(),'Software Developer')]")).click();

		/* Updating Years of Experience */
		WebElement accountDropdown = driver.findElement(By.xpath("//select[@id='experience']"));
		Select selectAccount = new Select(accountDropdown);
		selectAccount.selectByIndex(1);

		/* Click Next */
		explicitWaitb(driver);

		/* Updating Company name */
		Thread.sleep(2000);
		WebElement cName = driver.findElement(By.xpath("//input[@name='companyName']"));
		cName.click();
		cName.clear();
		cName.sendKeys("CG");

		/* Updating Job Level */
		WebElement accountDropdownj = driver.findElement(By.xpath("//select[@name='currentjob']"));
		Select selectAccountj = new Select(accountDropdownj);
		selectAccountj.selectByIndex(2);
		
		/* Upload resume using AutoIT */
		driver.findElement(By.xpath("//i[@class='icon-close_ico']")).click();
		driver.findElement(By.xpath("//input[@id='resume']")).click();
		Runtime.getRuntime().exec("C:\\Users\\VAIDEHI\\git\\repository2\\Vaidehi_Selenium\\script\\ResumeUpload.exe");

		/* Click Submit in Professional Details page */
		explicitWaitbp(driver);

		/* Click Submit in Career Interests page */
		Thread.sleep(2000);
		explicitWaitbp(driver);

		/* Save all the details */
		driver.findElement(By
				.xpath("//div[@class='finish-button-div hidden-xs']//button[@type='submit'][contains(text(),'Save')]"))
				.click();

		/* LogOut */
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@class='user_image']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

	}

	private static void explicitWaitbp(ChromeDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement button;
		button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		button.click();

	}

	private static void explicitWaitb(ChromeDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement button;
		button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue']")));
		button.click();

	}

	private static void explicitWait(ChromeDriver driver) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement link;
		link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ps-content']")));
	}

	private static void closeBrowser() {

		driver.quit();

	}

}
