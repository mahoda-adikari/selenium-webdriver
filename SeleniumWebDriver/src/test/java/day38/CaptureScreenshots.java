package day38;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Full Page Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile1 = ts.getScreenshotAs(OutputType.FILE);
		File targetFile1 = new File(System.getProperty("user.dir")+ "\\screenshots\\fullPage.png");
		Files.copy(sourceFile1.toPath(), targetFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//Web Element Screenshot
		WebElement table = driver.findElement(By.xpath("//div[@id='HTML8']//div[@class='widget-content']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		File sourceFile2 = table.getScreenshotAs(OutputType.FILE);
		File targetFile2 = new File(System.getProperty("user.dir")+ "\\screenshots\\table.png");
		Files.copy(sourceFile2.toPath(), targetFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		
		driver.quit();
	}

}
