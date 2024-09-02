package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String pCountText = driver.findElement(By.xpath("//ul[@id='pagination']/li[last()]")).getText();
		int pCountInt = Integer.parseInt(pCountText);
		
		for(int pNo=1; pNo<=pCountInt; pNo++) {
			WebElement pButton = driver.findElement(By.xpath("//a[normalize-space()='"+pNo+"']"));
			if (pNo>1) {
				pButton.click();
			}
			
			int rowsCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody//tr")).size();
			
			for(int rNo=1; rNo<=rowsCount; rNo++) {
				String id = driver.findElement(By.xpath("//table[@id='productTable']/tbody//tr["+rNo+"]/td[1]")).getText();
				String name = driver.findElement(By.xpath("//table[@id='productTable']/tbody//tr["+rNo+"]/td[2]")).getText();
				String price = driver.findElement(By.xpath("//table[@id='productTable']/tbody//tr["+rNo+"]/td[3]")).getText();
				driver.findElement(By.xpath("//table[@id='productTable']/tbody//tr["+rNo+"]/td[4]//input")).click();
				boolean isChecked = driver.findElement(By.xpath("//table[@id='productTable']/tbody//tr["+rNo+"]/td[4]//input")).isSelected();
				
				System.out.println(id+ "\t"+ name+ "\t"+ price+ "\t"+ isChecked);
			}
			
		}
		
	}

}
