package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class tets {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("files/test.xlsx");
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		int sheetno = 0;

		for (int i = 0; i <= excel.getNumberOfSheets(); i++) {
			if (excel.getSheetName(i).equalsIgnoreCase("Test")) {
				sheetno = i;
				break;
			} else {
				System.out.println("Sheet not found!!");
				assert (false);
			}
		}

		XSSFSheet sheet = excel.getSheetAt(sheetno);
		int column = 0;
		Iterator<Row> rowIte = sheet.iterator();
		Row row = rowIte.next();
		Iterator<Cell> cell = row.cellIterator();

		while (cell.hasNext()) {

			// if (row.getCell(column).getStringCellValue().equalsIgnoreCase("Test"))

			if (cell.next().getStringCellValue().equalsIgnoreCase("data")) {
				while (rowIte.hasNext()) {

					// Iterator<Cell> cell = row.cellIterator();

					// if (row.getCell(column).getStringCellValue().equalsIgnoreCase("Test")) {

					System.out.println(rowIte.next().getCell(column).getStringCellValue());
					// row = rowIte.next();

//			} else
//				column++;

				}
			}
			column++;
		}
	}
}
