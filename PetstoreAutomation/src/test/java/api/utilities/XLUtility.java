package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

    private static Workbook workbook;
    private static Sheet sheet;
    private static String excelPath =
            System.getProperty("user.dir") + "/testData/Userdata.xlsx";

    // Load Excel file
    public static void loadExcel(String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get cell data as String
    public static String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(
                sheet.getRow(rowNum).getCell(colNum));
    }

    // Get row count
    public static int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Get column count
    public static int getColumnCount(int rowNum) {
        return sheet.getRow(rowNum).getLastCellNum();
    }

    // Set cell data
    public static void setCellData(int rowNum, int colNum, String value) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null)
                row = sheet.createRow(rowNum);

            Cell cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(excelPath);
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Close Excel
    public static void closeExcel() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
