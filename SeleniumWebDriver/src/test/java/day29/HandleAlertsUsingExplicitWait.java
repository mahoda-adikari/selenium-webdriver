package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertsUsingExplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsPrompt()']"))).click();
		Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
		
		
		myAlert.sendKeys("foundItByMysef");
		myAlert.accept();
		
		String uName = "admin";
		String pwd = "admin";
		String bAuthUrl = "https://"+ uName+ ":"+ pwd+ "@"+ "the-internet.herokuapp.com/basic_auth";
		driver.get(bAuthUrl);
	}

}
