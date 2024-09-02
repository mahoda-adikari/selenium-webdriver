package day32;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment32 {

	public static void main(String[] args) {


		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement departure = driver.findElement(By.xpath("//select[@name='fromPort']"));
		WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
		
		Select selDep = new Select(departure);
		Select selDes = new Select(destination);
		selDep.selectByValue("Portland");
		selDes.selectByValue("Berlin");	
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> priceDollar = driver.findElements(By.xpath("//tbody/tr/td[6]"));
		List<Double> priceNoDollar = new ArrayList<Double>();
		
		for(WebElement eachPrice:priceDollar) {
			String priceText = eachPrice.getText();
			double priceValue = Double.parseDouble(priceText.replace("$", ""));
			priceNoDollar.add(priceValue);
		}
		
		double minPrice = Collections.min(priceNoDollar);
		
		
		int colCount = driver.findElements(By.xpath("//tbody/tr[1]/td")).size();
		int rowCount = driver.findElements(By.xpath("//tbody/tr")).size();
		
		for(int row=1; row<=rowCount; row++) {
			String priceFull = driver.findElement(By.xpath("//tbody/tr["+row+"]/td[6]")).getText();
			double priceOnly = Double.parseDouble(priceFull.replace("$", ""));
			if(priceOnly == minPrice) {
				driver.findElement(By.xpath("//tbody/tr["+row+"]/td[1]/input")).click();
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Jacob");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("22b/1, California South");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Blackwood");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("CA");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("11567");
		WebElement cardDrop = driver.findElement(By.xpath("//select[@id='cardType']"));
		Select selectCard = new Select(cardDrop);
		selectCard.selectByValue("amex");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("425687986212365");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("11");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2028");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("G J SMITH");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		if(driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed()) {
			System.out.println("Congrats...Test passed!!!");
		} else {
			System.out.println("Oops... Test Failed!!!");
		}
		
	}

}
