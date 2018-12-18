package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropJQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dim = new Dimension(768, 1024);
		driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		String beforeDrop = target.getCssValue("color");
		Actions action = new Actions(driver);
		//action.dragAndDrop(source, target).build().perform();
		
		action.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
		
		String afterDrop = target.getCssValue("color");
		
		System.out.println("Color before drag and drop: " + beforeDrop);
		System.out.println("Color after drag and drop: " + afterDrop);

	}

}
