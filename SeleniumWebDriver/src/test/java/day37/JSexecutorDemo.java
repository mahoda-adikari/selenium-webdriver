package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JSexecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
//		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		WebElement nameInput = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement genderInput = driver.findElement(By.xpath("//input[@id='male']"));
		WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
		JavascriptExecutor js = (JavascriptExecutor) driver; 	
//		JavascriptExecutor js = driver; 	
		
		js.executeScript("arguments[0].setAttribute('value','Jacob Smith');", nameInput);
		js.executeScript("arguments[0].click();", genderInput);
		js.executeScript("arguments[0].scrollIntoView(true);", datePicker);
		
		System.out.println("scrollOne X "+ js.executeScript("return window.pageXOffset;"));
		System.out.println("scrollOne Y "+ js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		System.out.println("scrollTwo X "+ js.executeScript("return window.pageXOffset;"));
		System.out.println("scrollTwo Y "+ js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		System.out.println("scrollThree X "+ js.executeScript("return window.pageXOffset;"));
		System.out.println("scrollThree Y "+ js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(1000);
		
		js.executeScript("document.body.style.zoom='250%'");
		
		Thread.sleep(1000);
		
		js.executeScript("document.body.style.zoom='50%'");
		

	}

}
