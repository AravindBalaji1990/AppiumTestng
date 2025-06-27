package dataproviderdemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilReadWrite {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheetname as Arguments to this method
    public static void setExcelFile(String Path, String SheetName) throws Exception {

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e) {
            throw (e);
        }
    }

    //Generic method to read the data
    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
        // intialisation to store the credentials from the excel and to be used int he dataprovider
        String[][] tabArray = null;// this will carry the final result read from the excel sheet
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            // temporary varibel to store the index values of the cell from the excel
            int ci, cj;
            // Total number of rows - which are filled in
            int totalRows = ExcelWSheet.getLastRowNum();
            // From the rows how many columns/cells are with data
            int noOfColumns = ExcelWSheet.getRow(totalRows).getLastCellNum();

            int col = noOfColumns ;
            tabArray = new String[totalRows][col];
            ci = 0;
            // Row values
            for (int i = 1; i <= totalRows; i++, ci++) {
                cj = 0;
                // Column values
                for (int j = 0; j < col; j++, cj++) {
                    // it will retrive the cell data based on the ci and cj index values
                    tabArray[ci][cj] = getCellData(i, j);// user defined method used it to seggregate the data
                    System.out.println("The values for i and j : " + tabArray[ci][cj]);
                }
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);

    }

    // This method is to read the test data from the Excel cell, in this we are
    // passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            //getStringCellValue- this will help us to convert the cell value to string
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }

    // Optional
    // Matching the classname with excel testcasename
    public static String getTestCaseName(String sTestCase) throws Exception {
        String value = sTestCase;
        try {
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
        int i;
        try {
            int rowCount = ExcelUtilReadWrite.getRowUsed();
            for (i = 0; i < rowCount; i++) {
                if (ExcelUtilReadWrite.getCellData(i, colNum).contains(sTestCaseName)) {
                    break;
                }
            }
            return i;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static int getRowUsed() throws Exception {

        try {
            int RowCount = ExcelWSheet.getLastRowNum() + 1;
            return RowCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

    public static void setCellData(String Result, int RowNum, int ColNum, String SheetName, String path) throws Exception {
        try {

            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            Row = ExcelWSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum);
            if (Cell == null) {
                // if cell isnot available then create the cell
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            } else {
                // if the cell is predefined just updated the cell
                Cell.setCellValue(Result);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
//            ExcelWBook = new XSSFWorkbook(new FileInputStream(DataProvider_Excel.Path_TestData));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
