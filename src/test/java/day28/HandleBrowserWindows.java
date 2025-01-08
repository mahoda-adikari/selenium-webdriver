package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowList = new ArrayList(windowIDs);
//		
//		String parentID = windowList.get(0);
//		String childID = windowList.get(1);
//		
//		System.out.println(driver.getTitle());
//		
//		driver.switchTo().window(parentID);
//		System.out.println(driver.getTitle());
		
		for(String winID:windowIDs) {
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM")) {
				driver.close();
			}
		}
		
	}

}
