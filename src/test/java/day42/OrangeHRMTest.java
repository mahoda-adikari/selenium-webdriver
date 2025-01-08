package day42;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	WebDriver driver;
	
	@Test(priority = 1)
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2)
	void checkLogo() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(5));
		boolean logoStatus = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo visibility check: "+ logoStatus);
	}
	
	@Test(priority = 3)
	void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(Duration.ofSeconds(10));
		
		boolean proPicStatus = driver.findElement(By.xpath("//img[@alt='profile picture']")).isDisplayed();
		System.out.println("Profile picture visibility: "+ proPicStatus);
	}
	
	@Test(priority = 4)
	void logout() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		Thread.sleep(Duration.ofSeconds(5));
		
		boolean logoutStatus = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed();
		System.out.println("Logout status "+ logoutStatus);
	}
	
	@Test(priority = 5)
	void closeApp() {
		driver.quit();
	}
	
}
