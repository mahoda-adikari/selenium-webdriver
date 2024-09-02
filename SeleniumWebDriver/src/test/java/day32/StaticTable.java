package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class StaticTable {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();		
		
		int tRowsCount = driver.findElements(By.xpath("//table[@name='BookTable']/descendant::tr")).size();
		int tColsCount = driver.findElements(By.xpath("//table[@name='BookTable']/descendant::th")).size();
		
		System.out.println("Table with "+ tRowsCount+ " rows and "+ tColsCount+ " columns....");
		
		int countAuthor = 0;
		String Author = "Mukesh";
		for(int row=1; row<=tRowsCount; row++) {
			for(int col=1; col<=tColsCount; col++) {
				String cellValue = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+row+"]/child::*["+col+"]")).getText();
				System.out.print(cellValue+"\t\t\t");
				if (cellValue.equals(Author)){
					countAuthor++;
				}
			}
			System.out.println("");
		}
		
		System.out.println("\n"+ countAuthor+ " books are written by "+ Author);
		
		int priceTotal = 0;
		for(int row=2; row<=tRowsCount; row++) {
			String cellValue = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+row+"]/child::*[4]")).getText();
			priceTotal+=Integer.parseInt(cellValue);
		}
		System.out.println("\nTotal price of books: "+priceTotal);
		double d = 23.443;
		System.out.println(Double.toString(d));
		
	}

}
