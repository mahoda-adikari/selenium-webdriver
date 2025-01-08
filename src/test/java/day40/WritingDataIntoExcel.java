package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir")+"\\testdata\\dataWrite.xlsx";
		FileOutputStream file = new FileOutputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("writeData");
		
		XSSFRow row1 = sheet.createRow(0);
			row1.createCell(0).setCellValue("Python");
			row1.createCell(1).setCellValue("2020-02-12");
			row1.createCell(2).setCellValue("350");
		
		XSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue("Selenium");
			row2.createCell(1).setCellValue("2020-03-31");
			row2.createCell(2).setCellValue("550");
		
		XSSFRow row3 = sheet.createRow(2);
			row3.createCell(0).setCellValue("Java");
			row3.createCell(1).setCellValue("2020-04-22");
			row3.createCell(2).setCellValue("650");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created!");
		
		
	}

}
