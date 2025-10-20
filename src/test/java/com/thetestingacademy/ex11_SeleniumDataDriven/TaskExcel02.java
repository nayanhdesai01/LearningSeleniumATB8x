package com.thetestingacademy.ex11_SeleniumDataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TaskExcel02 {
    //File Open
    //Read Data
    //Read the Excel file
public static void main(String [] args) throws IOException {
    FileInputStream fileInputStream = new FileInputStream("CTD2.xlsx");

    XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
    XSSFSheet sheet = workbook.getSheetAt(0);

    Iterator<Row> rowIterator = sheet.rowIterator();
    while (rowIterator.hasNext()){
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()){
            Cell cell = cellIterator.next();
            if(cell.getCellType()== CellType.NUMERIC){
                System.out.println(cell.getNumericCellValue());
            }
            if(cell.getCellType()== CellType.STRING) {
                System.out.println(cell.getStringCellValue());
            }
        }
    }

}

}
