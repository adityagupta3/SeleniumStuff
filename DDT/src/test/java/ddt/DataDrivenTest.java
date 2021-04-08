package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("files/test.xlsx");
		XSSFWorkbook testworkflow = new XSSFWorkbook(fis);
		// XSSFSheet sheet = new XSSFSheet();
		int sheets = testworkflow.getNumberOfSheets();

		int i;
		for (i = 0; i < sheets; i++) {

			if (testworkflow.getSheetName(i).equalsIgnoreCase("Test")) {
				break;
			} else
				System.out.println("TEST SHEET NOT FOUND!");

		}

		XSSFSheet sheet = testworkflow.getSheetAt(i);

		Iterator<Row> rows = sheet.iterator();
		int column = 0;
		int rowno = 0;

		while (rows.hasNext()) {

			Row row = rows.next();
			Iterator<Cell> cell = row.cellIterator();

			while (cell.hasNext()) {

				Cell value = cell.next();
				if (value.getStringCellValue().equalsIgnoreCase("Test")) {
					
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase("Login")) {
						
						while(cell.hasNext()) {
							
							System.out.println();
							
						}
					} else column++;
					System.out.println("(" + rowno + " , " + column + ")");

				}
				column++;
			}
			rowno++;
		}

	}

}
