package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SliderDemo {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		
		Point minSliderLoc = minSlider.getLocation();
		Point maxSliderLoc = maxSlider.getLocation();
		
		

	}

}
