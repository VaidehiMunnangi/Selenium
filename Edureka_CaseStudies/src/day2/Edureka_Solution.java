package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edureka_Solution {

	public void browser(String browser, String DriverPath) {
		/* Open the given url on given browser */
		String url = "https://www.edureka.co/";
		WebDriver driver = openBrowser(browser, DriverPath, url);
		/* Find element using "Id" locator */
		WebElement elementById = FindElement(driver, By.id("homeSearchBar"), 4);
		if (elementById != null)
			System.out.println("Element is present with the given id");
		else
			System.out.println("Element is not present with the given id ");
		/* Find element using "Name" locator */
		WebElement elementByName = FindElement(driver, By.name("user_v1[query]"), 4);
		if (elementByName != null)
			System.out.println("Element is present with the given name");
		else
			System.out.println("Element is not present with the given name");
		/* Find element using "Xpath" locator */
		WebElement elementByXpath = FindElement(driver, By.xpath("//*[@id='homeSearchBar']"), 4);
		if (elementByXpath != null)
			System.out.println("Element is present with the given Xpath");
		else
			System.out.println("Element is not present with the given Xpath ");
		/* Find element using "Css" locator */
		WebElement elementByCss = FindElement(driver, By.cssSelector("#homeSearchBar"), 4);
		if (elementByCss != null)
			System.out.println("Element is present with the given Css");
		else
			System.out.println("Element is not present with the given Css ");
		/* Find element using "Class Name" locator */
		WebElement elementByClass = FindElement(driver, By.className("search_input"), 4);
		if (elementByClass != null)
			System.out.println("Element is present with the given Class name ");
		else
			System.out.println("Element is not present with the given Class name ");
		/* Find element using "TagName" locator */
		WebElement elementByTag = FindElement(driver, By.tagName("button"), 4);
		if (elementByTag != null)
			System.out.println("Element is present with the given Tag name");
		else
			System.out.println("Element is not present with the given Tag name ");
		/* Find element using "LinkText" locator */
		WebElement elementByLinkText = FindElement(driver, By.linkText("Log In"), 4);
		if (elementByLinkText != null)
			System.out.println("Element is present with the given link text");
		else
			System.out.println("Element is not present with the given link text ");
		/* Find element using "Partial link text" locator */
		WebElement elementByPartialLinkText = FindElement(driver, By.partialLinkText("Log"), 4);
		if (elementByPartialLinkText != null)
			System.out.println("Element is present with the given partial link text ");
		else
			System.out.println("Element is not present with the given partial link text");
		/* Closing the Browser */
		closeBrowser(driver);
	}

	private static WebElement FindElement(WebDriver driver, By by, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(by)); // throws a time out exception if element not
																			// present after waiting <timeoutInSeconds>
																			// seconds
			return driver.findElement(by);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static WebDriver openBrowser(String browser, String DriverPath, String url) {
		WebDriver driver;
		if (browser == "chrome") {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			System.out.println("Launched Chrome Browser succesfully");
		} else {
			System.setProperty("webdriver.firefox.marionette", DriverPath);
			driver = new FirefoxDriver();
			System.out.println("Launched Firefox Browser succesfully");
		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
		return driver;
	}

	private static void closeBrowser(WebDriver driver) {
		try {
			driver.quit();
			System.out.println("The Browser closed succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
