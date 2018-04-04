package com.fox.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ExcelWriter {

    Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
    private Sheet sheet = workbook.createSheet("Show");
    private int rownum = 0;



    public void WriteToExcelSheet(ArrayList<String> shows){

        createHeader("Show");

        for(String show : shows){
            Row row  = sheet.createRow(rownum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(show);
        }

        try {
            String loc = Paths.get(".").toAbsolutePath().normalize().toString();
            FileOutputStream out = new FileOutputStream(new File(loc, "\\src\\test\\Output\\Fox_shows.xlsx"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Font createHeaderFont(){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        return headerFont;
    }

    private void createHeader(String header){
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(createHeaderFont());

        // Create a Header
        Row headerRow = sheet.createRow(rownum++);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue(header);
        headerCell.setCellStyle(headerCellStyle);

    }
}
