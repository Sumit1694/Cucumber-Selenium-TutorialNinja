package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\test\\testdata\\TestData.xlsx"; // best practice path

        ExcelUtils xlutil = new ExcelUtils(path); // create object for excel utility

        String sheetName = "LoginTestData"; // keep sheet name consistent
        int totalRows = xlutil.getRowCount(sheetName);
        int totalCols = xlutil.getCellCount(sheetName, 1);

        String loginData[][] = new String[totalRows][totalCols]; // 2D array

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData(sheetName, i, j);
            }
        }
        return loginData;
    }
}
