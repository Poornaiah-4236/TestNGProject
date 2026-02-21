package com.common.Tests;

import java.io.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	private static XSSFWorkbook Workbook;
	private static XSSFSheet Sheet;
	private static XSSFRow Row;
	private static XSSFCell Cell;
	private static final String filePath = new File(".//") + File.separator
			+ "/src/test/resources/TestData/UserData.xlsx";

	public static void main(String[] args) throws IOException {
		File dataFile = new File(filePath);
		FileInputStream fis = new FileInputStream(dataFile);
		Workbook = new XSSFWorkbook(fis);
		Sheet = Workbook.getSheetAt(0);
		int rows = Sheet.getLastRowNum();
		int colums = Sheet.getRow(0).getLastCellNum();
		for (int r = 0; r < rows; r++) {
			Row = Sheet.getRow(r);
			for (int c = 0; c < colums; c++) {
				Cell = Row.getCell(c);
				CellType cellType = Cell.getCellType();
				switch (cellType) {
				case STRING:
					System.out.println(Cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(Cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(Cell.getBooleanCellValue());
					break;
				case BLANK:
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				case _NONE:
					break;
				default:
					break;
				}
				System.out.println(" : ");
			}
			// System.out.println(" : ");
		}

	}

	/*
	 * public static CellType getCellData(int row,int colm) { try {
	 * Cell=Sheet.getRow(row).getCell(colm); CellType dataType = Cell.getCellType();
	 * switch(dataType) { case STRING: String value=Cell.getStringCellValue();
	 * break; case NUMERIC: int val=(int) Cell.getNumericCellValue(); break; case
	 * BOOLEAN: boolean val1=Cell.getBooleanCellValue(); }
	 * 
	 * return dataType; }catch (Exception e) {
	 * 
	 * } //return dataType; }
	 */
	public String getCellData(int row, int colum) {
		try {
			Cell = Sheet.getRow(row).getCell(colum);
			String cellData = Cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "";

	}
}
