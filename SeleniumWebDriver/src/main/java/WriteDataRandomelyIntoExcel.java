import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataRandomelyIntoExcel {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir")+"\\testdata\\dataWriteRandom.xlsx";
		FileOutputStream file = new FileOutputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("writeDynamicData");
		
		XSSFRow rowN = sheet.createRow(5);
		XSSFCell colN = rowN.createCell(3);
		
		colN.setCellValue("Gotchaaa!!!");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created!");
	}

}
