package day41;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\calcData.xlsx";
		
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for(int i=1; i<=rowCount; i++) {
			//Read Data from Excel file
			String principle = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String periodValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String periodType = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String maturityValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//Pass Data to application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(periodValue);
			
			Select periodTypeDD = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			periodTypeDD.selectByVisibleText(periodType);

			Select frequencyDD = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			frequencyDD.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			//Validation
			String actValue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(maturityValue) == Double.parseDouble(actValue)) {
				System.out.println("Row "+ i+ " Test Passed!");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
				ExcelUtils.fillGreen(filePath, "Sheet1", i, 7);
			} else {
				System.out.println("Row "+ i+ " Test Failed!");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
				ExcelUtils.fillRed(filePath, "Sheet1", i, 7);
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
		}
		
	}

}
