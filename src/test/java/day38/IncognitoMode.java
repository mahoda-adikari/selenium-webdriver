package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {

	public static void main(String[] args) {

		System.out.println("Testing...");
		
		ChromeOptions eOptions = new ChromeOptions();
		eOptions.addArguments("--incognito");
		eOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
//		ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(eOptions);
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
//		driver.quit();
	}

}
