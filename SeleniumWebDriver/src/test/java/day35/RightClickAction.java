package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement editOption = driver.findElement(By.xpath("//span[normalize-space()='Edit']"));
		
		Actions act = new Actions(driver);
		act.contextClick(rightClickBtn).perform();
		editOption.click();
		
		driver.switchTo().alert().accept();
	}

}
