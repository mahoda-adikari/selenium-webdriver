package demoBlaze;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/index.php");
		setDriver(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
