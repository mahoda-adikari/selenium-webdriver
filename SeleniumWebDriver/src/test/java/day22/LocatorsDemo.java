package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		
		System.out.println("Testing...");

		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
//		driver.findElement(By.name("search")).sendKeys("Mac");
//		driver.findElement(By.id("logo")).isDisplayed();
//		driver.findElement(By.linkText("Tablets")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.partialLinkText("mera")).click();
		List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
		System.out.println("Header Links Count: "+ headerLinks.size());
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links COunt: "+ allLinks.size());
		
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		System.out.println("Total Images Count: "+ allImages.size());
		
		driver.quit();
		
	}

}
