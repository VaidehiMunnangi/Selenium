package day7;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonProject {

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
		
		driver.get("http://www.amazon.in");
		
	}
	
	public void searchProduct(String text, String category) {
		
		WebElement element = driver.findElement(By.id("searchDropdownBox"));		
		Select select = new Select(element);
		select.selectByVisibleText(category);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']/input[@value='Go']")).click();
		
		String result = driver.findElement(By.id("s-result-count")).getText();
		System.out.println("Result: " + result);
		
	}
	
	public void printNthProduct(int itemNumber) {
		
		String productXPath = String.format("//ul[@id='s-results-list-atf']//li[@id='result_%d']", (itemNumber-1));
		String productDetails = driver.findElement(By.xpath(productXPath)).getText();
		String[] detailsArray = productDetails.split("\n");
		System.out.println("Product Name: " + detailsArray[1]);
		System.out.println(itemNumber + "th product is: " + productDetails);
	}
	
	public void printAllProducts() {
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li"));
		for (WebElement product : allProducts) {
			System.out.println("--------------------------------------------");
			System.out.println(product.getText());
		}
		
	}
	
	public void pritAllElementsViaScrollDownUsingMouse() {
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li"));
		Actions action = new Actions(driver);
		for(WebElement product : allProducts) {
			action.moveToElement(product).build().perform();
			System.out.println("------------------------------------------------");
			System.out.println(product.getText());
		}
	}
	
	public void printAllElementsViaScrollDownUsingJS() {
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li"));
		int X,Y;
		for(WebElement product:allProducts) {
			X = product.getLocation().x;
			Y = product.getLocation().y;
			scrollDown(X, Y);
			System.out.println("---------------------------------------------------");
			System.out.println(product.getText());
		}
	}
	
	private void scrollDown(int x,int y) {
		
		JavascriptExecutor jsEngine ;
		String jsCommand;
		jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		jsEngine = (JavascriptExecutor) driver;
		jsEngine.executeScript(jsCommand);
	}
}
