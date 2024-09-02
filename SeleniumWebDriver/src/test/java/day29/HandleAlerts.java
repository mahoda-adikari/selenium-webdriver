package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
//		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsAlert()']"))).click();
//		Alert myAlert = driver.switchTo().alert();
//		System.out.println(myAlert.getText());
//		myAlert.accept();
		
//		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsConfirm()']"))).click();
//		Alert myAlert = driver.switchTo().alert();
//		System.out.println(myAlert.getText());
//		myAlert.dismiss();
		
		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsPrompt()']"))).click();
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.sendKeys("amo Amor");
		myAlert.accept();
		
		
		
	}

}
