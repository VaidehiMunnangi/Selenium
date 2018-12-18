package day7;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageUploadAutoIT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			ChromeDriver driver;
			System.setProperty("webdriver.chrome.driver","C:\\Users\\VAIDEHI\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			Dimension dim = new Dimension(768, 1024);
			driver.manage().window().setSize(dim);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://images.google.com/?gws_rd=ssl");
			driver.findElement(By.className("S3Wjs")).click();
			driver.findElement(By.linkText("Upload an image")).click();
			driver.findElement(By.id("qbfile")).click();
			Runtime.getRuntime().exec("C:\\Users\\VAIDEHI\\git\\repository2\\Vaidehi_Selenium\\script\\imageupload.exe");

	}
}
