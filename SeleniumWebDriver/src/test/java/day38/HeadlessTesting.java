package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {

		System.out.println("Testing...");
		
		EdgeOptions eOptions = new EdgeOptions();
		eOptions.addArguments("--headless=new");
		
//		ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver(eOptions);
		driver.get("https://demo.opencart.com/");
		String actVal = driver.getTitle();
		String expVal = "Your Store";
		if(actVal.equals(expVal)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
			System.out.println("Expected value: "+ expVal+ "\nActual Value: "+ actVal);
		}
//		driver.close();
		driver.quit();
	}

}
