package day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathDemo {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.opencart.com");
		driver.manage().window().maximize();
		
		
//		driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("phonE");
//		driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("phonE");
//		driver.findElement(By.xpath("//input[contains(@name, 'earc')]")).sendKeys("computer");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.xpath("//*[contains(text(), '3 Pla')]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.findElement(By.xpath("//a[text()='MP3 Players']")).click();
//		driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).click();
//		boolean displayStatus = driver.findElement(By.xpath("//h3[normalize-space()='Featured']")).isDisplayed();
//		System.out.println(displayStatus);
//		
//		String displayText = driver.findElement(By.xpath("//h3[normalize-space()='Featured']")).getText();
//		System.out.println(displayText);
		
		boolean logoStatus = driver.findElement(By.xpath("//div[@id = 'logo']/a/img")).isDisplayed();
		System.out.println(logoStatus);
		String logoText = driver.findElement(By.xpath("//div[@id = 'logo']/a/img")).getText();
		System.out.println(logoText);
		
		
	}

}
