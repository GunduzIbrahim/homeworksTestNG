package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static String cellValue;


    public String cellValueCall(int sheetId, int rowId,int cellId) throws IOException {

        String path = "./src/test/resources/UserInformation.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook userInformation = WorkbookFactory.create(fileInputStream);

//        Sheet userNames = userInformation.getSheetAt(0);
//        Sheet validEmails = userInformation.getSheetAt(1);
//        Sheet invalidEmails = userInformation.getSheetAt(2);
//        Sheet validPasswords = userInformation.getSheetAt(3);
//        Sheet invalidPasswords = userInformation.getSheetAt(4);

        cellValue = userInformation.getSheetAt(sheetId).getRow(rowId).getCell(cellId).getStringCellValue();

        return cellValue;
    }
}
