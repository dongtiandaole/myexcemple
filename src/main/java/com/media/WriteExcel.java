package com.media;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class WriteExcel {
    public static void creatExcel( List<medias> pdfsList) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");

        HSSFRow row = hssfSheet.createRow(0);
        row.createCell(0).setCellValue("code");
        row.createCell(1).setCellValue("functree");
        row.createCell(2).setCellValue("new_file_name");
        row.createCell(3).setCellValue("title");


        for (int i = 0; i < pdfsList.size(); i++) {
            medias pdfs = pdfsList.get(i);
            HSSFRow rows = hssfSheet.createRow(i + 1);
            rows.createCell(0).setCellValue(pdfs.getCode());
            rows.createCell(1).setCellValue(pdfs.getSns());
            rows.createCell(2).setCellValue(pdfs.getRename());
            rows.createCell(3).setCellValue(pdfs.getName());


        }
        try {
            FileOutputStream out = new FileOutputStream("D:\\项目文档\\medias.xls");
            hssfWorkbook.write(out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
