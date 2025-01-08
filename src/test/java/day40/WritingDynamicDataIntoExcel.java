package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir")+"\\testdata\\dataWriteDynamic.xlsx";
		FileOutputStream file = new FileOutputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("writeDynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Rows Count: ");
		int rowsCount = sc.nextInt();
		System.out.println("Enter Cols Count: ");
		int colsCount = sc.nextInt();
		
		for(int r=0; r<rowsCount; r++) {
			XSSFRow currRow = sheet.createRow(r);
			
			for(int c=0; c<colsCount; c++) {
				XSSFCell currCell = currRow.createCell(c);
				System.out.println("Enter value for Row: "+ r+ "Col: "+ c);
				currCell.setCellValue(sc.next());
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created!");
	}

}
