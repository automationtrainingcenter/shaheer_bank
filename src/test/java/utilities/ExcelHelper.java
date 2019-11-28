package utilities;

import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelHelper {
    private Workbook book;
    private Sheet sh;

    // open excel
    public void openExcel(String folderName, String fileName, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(GenericHelper.getFilePath(folderName, fileName));
            book = Workbook.getWorkbook(fis);
            sh = book.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get number of rows
    public int rowCount() {
        return sh.getRows();
    }

    // get number of columns
    public int columnCount() {
        return sh.getColumns();
    }

    // read data
    public String readData(int rnum, int cnum) {
        return sh.getCell(cnum, rnum).getContents();
    }

    // close excel
    public void closeExcel() {
        book.close();
    }

    // get sheet data
    public String[][] getSheetData(String folderName, String fileName, String sheetName) {
        openExcel(folderName, fileName, sheetName);
        int nor = rowCount();
        int noc = columnCount();
        String[][] data = new String[nor - 1][noc];
        for (int r = 1; r < nor; r++) {
            for(int c = 0; c < noc; c++){
                data[r-1][c] = readData(r, c);
            }
        }
        return data;
    }
}
