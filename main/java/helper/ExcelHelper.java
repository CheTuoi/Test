package helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelHelper {

    public static Object[][] getData(String sheetName) {

        File file = new File("testdata/CreateBooking.xlsx");
        XSSFWorkbook workbook = null;
        try {
            InputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rows = sheet.rowIterator();

        Row firstRow = rows.next();
        int lastCellIndex = firstRow.getLastCellNum() - 1;
        Object[][] data = new Object[sheet.getLastRowNum()][lastCellIndex];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row r = rows.next();
            Iterator<Cell> cells = r.cellIterator();
            cells.next();
            for (int j = 0; j < lastCellIndex; j++) {
                Cell cell = cells.next();
                if (cell.getCellType() == CellType.STRING || cell.getCellType() == CellType.BLANK) {
                    data[i][j] = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    data[i][j] = cell.getNumericCellValue();
                } else if (cell.getCellType() == CellType.BOOLEAN) {
                    data[i][j] = cell.getBooleanCellValue();
                } else if (cell.getCellType() == CellType.FORMULA) {
                    data[i][j] = cell.getCellFormula();
                }
            }
        }

        return data;
    }
}

