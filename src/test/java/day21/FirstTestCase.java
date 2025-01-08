package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTestCase {

	public static void main(String[] args) {

		System.out.println("Testing...");
		
//		ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
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
