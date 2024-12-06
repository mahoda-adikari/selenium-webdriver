package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "dp")
	void testLogin(String email, String password) throws InterruptedException {
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(Duration.ofSeconds(5));
		
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status == true) {
			driver.findElement(By.xpath("//span[@class='caret']")).click();
			driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	
	@DataProvider(name = "dp")
	Object[][] loginData() {
		Object[][] loginCreds = {
	            {"ayo@xmail.com", "ayo123"},
	            {"test.user2@domain.com", "qwerty2023"},
	            {"sample_user3@mail.com", "pass!word567"},
	            {"random.user4@site.org", "secure*789"},
	            {"user5.test@web.net", "myp@ssword123"}
	        };
		return loginCreds;
	}

}
