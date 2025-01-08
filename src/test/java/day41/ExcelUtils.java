package day41;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlFile, String xlSheet) throws FileNotFoundException, IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws FileNotFoundException, IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
		
	}
	
	
	public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws FileNotFoundException, IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		String cellData;
		
		try {
//			cellData = cell.toString();
			DataFormatter dfm = new DataFormatter();
			cellData = dfm.formatCellValue(cell);
		} catch (Exception e) {
			cellData = "";
		}
		
		wb.close();
		fi.close();
		return cellData;
	}
	
	
	public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws FileNotFoundException, IOException{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	
//	public static void fillGreen(String xlFile, String xlSheet, int rowNum, int colNum) throws FileNotFoundException, IOException{
//		fi = new FileInputStream(xlFile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlSheet);
//		row = ws.getRow(rowNum);
//		cell = row.getCell(colNum);
//		
//		style = wb.createCellStyle();
//		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//		
//		cell.setCellStyle(style);
//		fo = new FileOutputStream(xlFile);
//		wb.write(fo);
//		wb.close();
//		fi.close();
//		fo.close();
//	}
//	
//	
//	public static void fillRed(String xlFile, String xlSheet, int rowNum, int colNum) throws FileNotFoundException, IOException{
//		fi = new FileInputStream(xlFile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlSheet);
//		row = ws.getRow(rowNum);
//		cell = row.getCell(colNum);
//		
//		style = wb.createCellStyle();
//		style.setFillForegroundColor(IndexedColors.RED.getIndex());
//		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//		
//		cell.setCellStyle(style);
//		fo = new FileOutputStream(xlFile);
//		wb.write(fo);
//		wb.close();
//		fi.close();
//		fo.close();
//	}
	
	
	public static void fillGreen(String xlFile, String xlSheet, int rowNum, int colNum) throws FileNotFoundException, IOException{
		applyColor(xlFile, xlSheet, rowNum, colNum, IndexedColors.GREEN);
	}
	
	public static void fillRed(String xlFile, String xlSheet, int rowNum, int colNum) throws FileNotFoundException, IOException{
		applyColor(xlFile, xlSheet, rowNum, colNum, IndexedColors.RED);
	}
	
	public static void applyColor(String xlFile, String xlSheet, int rowNum, int colNum, IndexedColors color) throws FileNotFoundException, IOException{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
