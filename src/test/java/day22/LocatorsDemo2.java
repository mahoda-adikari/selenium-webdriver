package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorsDemo2 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://demoblaze.com/index.html");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links Count: "+ allLinks.size());
		
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		System.out.println("Total Image Count: "+ allImages.size());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Nokia lumia 1520")).click();
	}

}
