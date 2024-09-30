package day41;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment41 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\cdCalc.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for(int i=1; i<=rowCount; i++) {
			String iniDepAmount = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String lenMonths = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String inRate = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String compType = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String totValueExpected = ExcelUtils.getCellData(filePath, "Sheet1", i, 4).replace("$", "").replace(",", "");
			
			WebElement iniDepAmountWE = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			WebElement lenMonthsWE = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			WebElement inRateWE = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			WebElement compTypeDropDownWE = driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
			WebElement calcButtonWE = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']"));
			
			iniDepAmountWE.clear();
			iniDepAmountWE.sendKeys(iniDepAmount);
			
			lenMonthsWE.clear();
			lenMonthsWE.sendKeys(lenMonths);
			
			inRateWE.clear();
			inRateWE.sendKeys(inRate);
			
			compTypeDropDownWE.click();
			WebElement compTypeWE = driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='Compounded Monthly']"));
			compTypeWE.click();
			
			calcButtonWE.click();
			
			String totValueActual = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(Double.parseDouble(totValueExpected) == Double.parseDouble(totValueActual.replace("$", "").replace(",", ""))) {
				System.out.println("Test "+ i+ " Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Pass");
				ExcelUtils.fillGreen(filePath, "Sheet1", i, 6);
			} else {
				System.out.println("Test "+ i+ " Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Fail");
				ExcelUtils.fillRed(filePath, "Sheet1", i, 6);
				f
			}
		}
		
	}
}
