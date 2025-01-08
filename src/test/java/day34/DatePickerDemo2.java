package day34;

import java.time.Duration;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerDemo2 {
	
	static void selectDate(WebDriver driver, WebDriverWait myWait, String day, String month, String year) {
		
		WebElement yearDropDown = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
		Select yearSelect = new Select(yearDropDown);
		yearSelect.selectByVisibleText(year);
		
		while(true) {
			String currM = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			int currMNo = Month.valueOf(currM.toUpperCase()).getValue();
			int monthNo = Month.valueOf(month.toUpperCase()).getValue();
			
			if (currMNo == monthNo) {
				break;
			} else if (currMNo < monthNo) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else if ((currMNo > monthNo)){
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
		}
		
		List<WebElement> daysList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		for (WebElement eachDay:daysList) {
			if (eachDay.getText().equals(day)) {
				eachDay.click();
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String day = "17";
		String month = "April";
		String year = "2023";
		
		driver.switchTo().frame("frame-one796456169");
		WebElement datePickerIcon = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='icon_calendar']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePickerIcon);
		datePickerIcon.click();
//		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

		selectDate(driver, myWait, day, month, year);
	}

}
