package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		List<WebElement> dayChecks = driver.findElements(By.xpath("//div[@class='post-body entry-content']/child::div[4]//input"));
		
		for (WebElement day:dayChecks) {
			day.click();
		}
		
		for (int i=dayChecks.size()-3; i<dayChecks.size(); i++) {
			dayChecks.get(i).click();
		}
	}

}
