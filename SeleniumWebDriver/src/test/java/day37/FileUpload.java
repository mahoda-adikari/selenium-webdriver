package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUpload {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		String fileOnePath = "C:\\Users\\acer\\Desktop\\testDirectory\\sampleOne.txt";
		String fileTwoPath = "C:\\Users\\acer\\Desktop\\testDirectory\\sampleTwo.png";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(fileOnePath);
		String addedFileName = driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText();
		
		if (addedFileName.equals("sampleOne.txt")) {
			System.out.println("upoad Verified!");
		} else {
			System.out.println("upload not Verified!");
		}
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(fileOnePath+ "\n"+ fileTwoPath);

		int fileListSize = driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();
		System.out.println(fileListSize+ " files Uploaded");
	}

}
