package day26;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GetMethods {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		System.out.println("Page Title: "+ driver.getTitle());
		System.out.println("Page URL: "+ driver.getCurrentUrl());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> pageIDs = driver.getWindowHandles();
		System.out.println("Page IDs: "+ pageIDs);
		
	}

}
