package com.murali.learnings.automation.selautomationfw.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtility {

	private static XSSFWorkbook ExcelWorkBook;
	private static XSSFSheet ExcelSheet;
	private static XSSFRow Row;
	private static XSSFCell Cell;
	static FileInputStream excelFile;

	public static void readExcelFile() throws IOException {

		try {
			excelFile = new FileInputStream("C:\\Users\\navee\\Projects\\selautomationfw\\data\\TestData.xlsx");
			ExcelWorkBook = new XSSFWorkbook(excelFile);
			ExcelSheet = ExcelWorkBook.getSheet("data");
			System.out.println(ExcelSheet);
			Cell = ExcelSheet.getRow(4).getCell(0);
			String cellData = Cell.getStringCellValue();
			System.out.println(cellData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String[][] getExcelData() {

		String[][] data = null;
		try {
			excelFile = new FileInputStream("C:\\Users\\navee\\Projects\\selautomationfw\\data\\TestData.xlsx");
			ExcelWorkBook = new XSSFWorkbook(excelFile);
			ExcelSheet = ExcelWorkBook.getSheet("data");
			Row = ExcelSheet.getRow(0);
			int noOfRows = ExcelSheet.getPhysicalNumberOfRows();
			int noOfCols = Row.getLastCellNum();
			data = new String[noOfRows - 1][noOfCols];
			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					Row = ExcelSheet.getRow(i);
					Cell = Row.getCell(j);
					data[i - 1][j] = Cell.getStringCellValue();
				}
			}
		} catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}

	public static void main(String[] args) throws IOException {
		//readExcelFile();
		System.out.println(getExcelData());
	}

}
