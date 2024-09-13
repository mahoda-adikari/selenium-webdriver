package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRun {

	public static void main(String[] args) {

		System.out.println("Testing...");
		
		ChromeOptions eOptions = new ChromeOptions();
		File crxFile = new File("C:\\Users\\acer\\Documents\\Automation\\supportFiles\\uBlock-Origin-Chrome-Web-Store.crx");
		eOptions.addExtensions(crxFile);
		
//		ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(eOptions);
		driver.get("https://text-compare.com/");
		
//		driver.close();
//		driver.quit();
	}

}
