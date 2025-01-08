package day34;

import java.time.Duration;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DatePickerDemo {
	
	static void selectDate(WebDriver driver, String day,String month, String year) {
		int monthNo = Month.valueOf(month.toUpperCase()).getValue();
		int yearNo = Integer.parseInt(year);
		
		while(true) {
			String currM = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currY = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			int currMNo = Month.valueOf(currM.toUpperCase()).getValue();
			int currYNo = Integer.parseInt(currY);
			
			if (currMNo == monthNo && currYNo == yearNo) {
				break;
			} else if (currYNo < yearNo || (currYNo == yearNo && currMNo < monthNo)) {
				driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-icon-circle-triangle-e')]")).click();
			} else if (currYNo > yearNo || (currYNo == yearNo && currMNo > monthNo)) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} 
		}
		
		List<WebElement> dateList = driver.findElements(By.xpath("//tbody/tr/td"));
		for(WebElement date:dateList) {
			if(date.getText().equals(day)) {
				date.click();
			}
		}
		
	}
	
	public static void main (String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/16/2024");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String day = "16";
		String month = "October";
		String year = "2023";
		selectDate(driver, day, month, year);
	}

}


		
