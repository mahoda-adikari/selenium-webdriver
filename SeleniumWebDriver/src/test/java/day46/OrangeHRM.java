package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(day46.MyListener.class)
public class OrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	void testLogo() {
		boolean logoStatus = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logoStatus, true);
	}

	@Test(priority = 2)
	void testAppURL() {
		String appURL = driver.getCurrentUrl();
		Assert.assertEquals(appURL, "https://opensource-demo.orangehrmWRONGURL.com/web/index.php/auth/login");
	}

	@Test(priority = 3, dependsOnMethods = {"testAppURL"})
	void testHomePageTitle() {
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
