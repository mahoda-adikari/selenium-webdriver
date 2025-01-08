package day28;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		WebDriver driver = new EdgeDriver();
//		driver.get("https://demo.opencart.com/");
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to("https://demo.opencart.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());		
//		URL myURL = new URL("https://demo.opencart.com/");
//		driver.navigate().to(myURL);
		
		driver.navigate().refresh();
		
		
		
	}

}
