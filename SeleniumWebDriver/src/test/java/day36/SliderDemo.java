package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
	
	public static void sliderAdjust(WebDriver driver, int minVal, int maxVal) {
		Actions act = new Actions(driver);
		
		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		
		Point minSliderLoc = minSlider.getLocation();
		Point maxSliderLoc = maxSlider.getLocation();
		
		int minInc = 5;
		int minDec = -5;
		int maxInc = 5;
		int maxDec = -5;
		
		Action minSliderInc = act.dragAndDropBy(minSlider, minInc, minSliderLoc.y).build();
		Action minSliderDec = act.dragAndDropBy(minSlider, minDec, minSliderLoc.y).build();
		Action maxSliderInc = act.dragAndDropBy(maxSlider, maxInc, maxSliderLoc.y).build();
		Action maxSliderDec = act.dragAndDropBy(maxSlider, maxDec, maxSliderLoc.y).build();

		
//		while(true) {
//			int currMinVal = Integer.parseInt(driver.findElement(By.xpath("//input[@id='min_price']")).getAttribute("value"));
//			int currMaxVal = Integer.parseInt(driver.findElement(By.xpath("//input[@id='max_price']")).getAttribute("value"));
//			
//			if (minVal == currMinVal && maxVal == currMaxVal) {
//				break;
//			} else if (minVal == currMinVal && maxVal < currMaxVal) {
//				maxSliderDec.perform();
//			} else if (minVal == currMinVal && maxVal > currMaxVal) {
//				minSliderInc.perform();
//			} else if (minVal < currMinVal && maxVal == currMaxVal) {
//				minSliderDec.perform();
//			} else if (minVal > currMinVal && maxVal == currMaxVal) {
//				minSliderInc.perform();
//			} else if (minVal > currMinVal && maxVal > currMaxVal) {
//				minSliderInc.perform();
//				maxSliderInc.perform();
//			} else if (minVal < currMinVal && maxVal < currMaxVal) {
//				minSliderDec.perform();
//				maxSliderDec.perform();
//			} else if (minVal > currMinVal && maxVal < currMaxVal) {
//				minSliderInc.perform();
//				maxSliderDec.perform();
//			} else if (minVal < currMinVal && maxVal > currMaxVal) {
//				minSliderDec.perform();
//				maxSliderInc.perform();
//			}
//
//
//		}
		
		while(true) {
			int currMinVal = Integer.parseInt(driver.findElement(By.xpath("//input[@id='min_price']")).getAttribute("value"));
			if (minVal == currMinVal) {
				break;
			} else if (minVal < currMinVal) {
				minSliderDec.perform();
			} else if (minVal > currMinVal) {
				minSliderInc.perform();
			} 
		}
		
		while(true) {
			int currMaxVal = Integer.parseInt(driver.findElement(By.xpath("//input[@id='max_price']")).getAttribute("value"));
			if (maxVal == currMaxVal) {
				break;
			} else if (maxVal < currMaxVal) {
				maxSliderDec.perform();
			} else if (maxVal > currMaxVal) {
				maxSliderInc.perform();
			} 
		}
	}

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		

		sliderAdjust(driver, 1700, 8900);

	}

}
