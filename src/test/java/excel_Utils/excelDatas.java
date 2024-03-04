package excel_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDatas {

	public static String fileLocation = "./testData_excel.xlsx";
	public static String workBookSheetName = "Sheet 1";
	public static FileInputStream ipStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow rowNumber;
	public static XSSFCell cellValue;
	
	public static void commonExcelSteps(String filePath, String sheetName) throws IOException {
		ipStream = new FileInputStream(filePath);
		workBook = new XSSFWorkbook(ipStream);
		sheet = workBook.getSheet(sheetName);
	}
	
	public static int getLastRowCount() throws IOException {
		commonExcelSteps(fileLocation, workBookSheetName);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		return rowCount;
	}
	
	public static short getLastColumnCount(int row) throws IOException {
		commonExcelSteps(fileLocation, workBookSheetName);
		short columnCount = sheet.getRow(row).getLastCellNum();
		workBook.close();
		return columnCount;
	}
	
	public static String getCellValue(int row, int column) throws IOException {
		commonExcelSteps(fileLocation, workBookSheetName);
		rowNumber = sheet.getRow(row);
		cellValue = rowNumber.getCell(column);
		
		DataFormatter dataFormat = new DataFormatter();
		String cellData = dataFormat.formatCellValue(cellValue);
		workBook.close();
		return cellData;
		
	}
	
}
