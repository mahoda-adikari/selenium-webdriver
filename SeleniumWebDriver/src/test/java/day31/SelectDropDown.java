package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement countryDropWE = driver.findElement(By.xpath("//select[@id='country']"));
		Select countryDropSelect  = new Select(countryDropWE);
//		countryDropSelect.selectByVisibleText("Australia");
		countryDropSelect.selectByValue("australia");
		List<WebElement> countryList = countryDropSelect.getOptions();
		System.out.println("All countries = "+countryList.size());
		
		for(WebElement country:countryList) {
			System.out.println(country.getText());
		}
		
		
		
	}

}
