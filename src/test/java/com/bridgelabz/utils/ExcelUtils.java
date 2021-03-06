package com.bridgelabz.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet excelWSheet;

    private static XSSFWorkbook excelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName) {

        String[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            excelWBook = new XSSFWorkbook(ExcelFile);

            excelWSheet = excelWBook.getSheet(SheetName);

            int startRow = 1;

            int startCol = 1;

            int ci,cj;

            int totalRows = excelWSheet.getLastRowNum();
            System.out.println("totalRows :" + totalRows);

            // you can write a function as well to get Column count

            int totalCols = excelWSheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("totalCols :" + totalCols);

            tabArray=new String[totalRows][totalCols-1];

            ci=0;

            for (int i=startRow;i<=totalRows;i++, ci++) {

                cj=0;

                for (int j=startCol;j<=totalCols-1;j++, cj++){

                    System.out.println("row :"+i + "Col :"+ j);

                    tabArray[ci][cj]=getCellData(i,j);

                    System.out.println(tabArray[ci][cj]);

                }

            }

        }

        catch (FileNotFoundException e){

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e){

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) {

//        try {

            Cell = excelWSheet.getRow(RowNum).getCell(ColNum);

//            int dataType = Cell.getCellType();
//
//            if (dataType == 3) {
//
//                return "";
//
//            } else {

        return Cell.getStringCellValue();

//            }}catch(Exception e){
//
//                System.out.println(e.getMessage());
//
//                throw (e);
//
//            }

        }
}
