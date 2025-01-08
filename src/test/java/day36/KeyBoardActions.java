package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.text-compare.com");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Hola Amigo");
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		driver.get("https://the-internet.herokuapp.com/");
		WebElement navLink = driver.findElement(By.xpath("//a[normalize-space()='A/B Testing']"));
		act.keyDown(Keys.CONTROL).click(navLink).keyUp(Keys.CONTROL).perform();
		
		List<String> winIDs = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(winIDs.get(1));
		driver.findElement(By.xpath("//a[@target='_blank']")).click();
		Thread.sleep(1000);
		driver.switchTo().window(winIDs.get(0));
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://jqueryui.com/datepicker/");
	}

}
