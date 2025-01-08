package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
	
	WebDriver driver;
//	ChromeOptions options;

	@BeforeClass
	@Parameters({"browser", "url"})
	void setup(String br, String url) throws InterruptedException {
//		options = new ChromeOptions();
//		options.addArguments("--headless=new");
//		driver = new ChromeDriver(options);
		
		switch (br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid browser configuration!"); return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	void testLogo() {
		boolean logoVisibility = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logoVisibility, true);
	}
	
	@Test(priority = 2)
	void testTitle() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "OrangeHRM");
	}
	
	@Test(priority = 3)
	void testURL() {
		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals(pageURL , "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	} 
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
