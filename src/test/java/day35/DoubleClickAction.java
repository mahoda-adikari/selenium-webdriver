package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement dblClickBtn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		field1.clear();
		field1.sendKeys("Meemow");
		
		Actions act = new Actions(driver);
		act.doubleClick(dblClickBtn).perform();
		
		if (field1.getAttribute("value").equals(field2.getAttribute("value"))) {
			System.out.println("Verified entry");
		} else {
			System.out.println("Verification failed!");
		}
		
		System.out.println("F1: "+ field1.getAttribute("value"));
		System.out.println("F2: "+ field2.getAttribute("value"));

	}

}
