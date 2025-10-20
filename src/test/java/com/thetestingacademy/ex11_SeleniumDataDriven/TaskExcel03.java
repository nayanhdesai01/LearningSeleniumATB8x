package com.thetestingacademy.ex11_SeleniumDataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskExcel03 {
    public static void main(String[] args) throws IOException {


        //Create Cell at Specific position

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row=sheet.createRow(1);
        Cell cell=row.createCell(1);

        cell.setCellValue("ABC");

        FileOutputStream outputStream = new FileOutputStream(new File("CellSpecific.xlsx"));
        workbook.write(outputStream);
        outputStream.close();
    }
}
