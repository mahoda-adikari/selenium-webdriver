package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathDemo2 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.opencart.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	    driver.findElement(By.xpath("//div[@id='narbar-menu']/descendant::li[4]")).click();
//		driver.findElement(By.xpath("//div[@id='narbar-menu']/ul//li[5]/following-sibling::li")).click();
		driver.findElement(By.xpath("//div[@id='header-cart']/preceding::div/following::input")).sendKeys("aaaaa");
	}

}
