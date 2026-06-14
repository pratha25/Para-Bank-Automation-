package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static void writeData(
	        String sheetName,
	        int row,
	        int cell,
	        String value) {

	    String path = "testdata/ParaBankData1.xlsx";

	    try {

	        FileInputStream fis =
	                new FileInputStream(path);

	        XSSFWorkbook wb =
	                new XSSFWorkbook(fis);

	        XSSFSheet sheet =
	                wb.getSheet(sheetName);

	        sheet.getRow(row)
	             .getCell(cell)
	             .setCellValue(value);

	        fis.close();

	        FileOutputStream fos =
	                new FileOutputStream(path);

	        wb.write(fos);

	        fos.close();

	        wb.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}

    public static String getData(
            String sheetName,
            int row,
            int cell) {

        String path = "testdata/ParaBankData1.xlsx";

        try {

            FileInputStream fis =
                    new FileInputStream(path);

            XSSFWorkbook wb =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    wb.getSheet(sheetName);

            String value =
                    sheet.getRow(row)
                         .getCell(cell)
                         .toString();

            wb.close();

            return value;

        } catch (Exception e) {

            e.printStackTrace();
            return "";
        }
    }
}