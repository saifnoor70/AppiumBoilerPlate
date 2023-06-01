package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHelper {
    public static String readDataFromExcel(int rowNumber, int columnNumber) throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ExcelFile/InputData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println(sheet.getRow(rowNumber).getCell(columnNumber));
        return String.valueOf(sheet.getRow(rowNumber).getCell(columnNumber));
    }
}
