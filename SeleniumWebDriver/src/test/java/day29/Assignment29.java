package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment29 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> chkBoxInTable = driver.findElements(By.xpath("//tbody/descendant::input"));
		
		for (WebElement eachChkBox:chkBoxInTable) {
			eachChkBox.click();
		}
	}

}
