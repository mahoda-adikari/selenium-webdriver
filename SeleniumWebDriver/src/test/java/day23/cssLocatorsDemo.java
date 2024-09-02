package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class cssLocatorsDemo {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//		driver.findElement(By.cssSelector("img[alt='iPhone']")).click();
//		driver.findElement(By.cssSelector("img.img-fluid[alt='iPhone']")).click();
		driver.findElement(By.cssSelector("input.form-control.form-control-lg")).sendKeys("tAb");
		driver.findElement(By.cssSelector(".fa-solid.fa-magnifying-glass")).click();
		

//		driver.quit();
	}

}
