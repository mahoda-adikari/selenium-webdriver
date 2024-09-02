package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment28 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium"+ Keys.ENTER);
		
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
		
		System.out.println("Search Results Count: "+ searchResults.size());
		
		for(WebElement link:searchResults) {
			link.click();
		}
		
		Set<String> winIDs = driver.getWindowHandles();
		
		for(String winID:winIDs) {
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
			
			if(title.equals("Selenium in biology - Wikipedia") || title.equals("Selenium dioxide - Wikipedia") || title.equals("Selenium disulfide - Wikipedia")) {
				System.out.println(title+ " is closing");
				driver.close();
			}
		}
	}

}
