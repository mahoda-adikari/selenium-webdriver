package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com");
		driver.manage().window().maximize();
		
		WebElement desktopTab = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement macOption = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act = new Actions(driver);
//		act.moveToElement(desktopTab).moveToElement(macOption).click().build().perform();
		act.moveToElement(desktopTab).moveToElement(macOption).click().perform();

		
	}

}
