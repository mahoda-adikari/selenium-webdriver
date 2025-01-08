package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BootstrapSelect {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		WebElement multiDrop = driver.findElement(By.xpath("//span[@class='multiselect-selected-text']"));
		multiDrop.click();
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/descendant::label"));
		for(WebElement chk:allOptions) {
			chk.click();
			System.out.println(chk.getText());
		}
	}

}
