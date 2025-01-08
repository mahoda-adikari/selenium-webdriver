package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement box = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);
//		act.clickAndHold(box).moveToElement(destination).click().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", destination);
		act.dragAndDrop(box, destination).perform();
		
	}

}
