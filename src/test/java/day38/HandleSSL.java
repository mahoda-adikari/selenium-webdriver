package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		
		EdgeOptions eOptions = new EdgeOptions();
		eOptions.setAcceptInsecureCerts(true);

		WebDriver driver = new EdgeDriver(eOptions);
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Page Title: "+ driver.getTitle());
	}

}
