package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConditionalMethods {

	public static void main(String[] args) {

		WebDriver driver  = new EdgeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.xpath("//img[@title='SH_512x512']"));
		System.out.println("Logo status: "+ logo.isDisplayed());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//label[normalize-space()='Can you enter name here through automation']//*[name()='svg']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		WebElement fName = driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
//		System.out.println("First Name status: "+ fName.isEnabled());
		WebElement fNameDup = driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
		System.out.println("First Name status: "+ fNameDup.isEnabled());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First Enter name']")));
		fName.sendKeys("daheck???????");
		System.out.println("First Name status: "+ fName.isEnabled());
		
		WebElement cb = driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_16']"));
		System.out.println(cb.isSelected());
		cb.click();
		System.out.println(cb.isSelected());

	}

}
