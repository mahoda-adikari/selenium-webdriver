package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir")+"\\testdata\\data.xlsx";
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		workbook.getSheetAt(0);
		int rowsCount = sheet.getLastRowNum();
		int colsCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Rows: "+ rowsCount);
		System.out.println("Total Columns: "+ colsCount);
		
		for(int r=0; r<=rowsCount; r++) {
			XSSFRow currRow = sheet.getRow(r);
			
			for(int c=0; c<colsCount; c++) {
				XSSFCell currCell = currRow.getCell(c);
				System.out.print(currCell.toString()+ "\t");
			}
			
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}

}
