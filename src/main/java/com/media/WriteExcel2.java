package com.media;

import com.media.entity.dmEntity;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class WriteExcel2 {
    public static void creatExcel(List<dmEntity> dmEntities ) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");

        HSSFRow row = hssfSheet.createRow(0);
        row.createCell(0).setCellValue("tech_name");
        row.createCell(1).setCellValue("icv");
        row.createCell(2).setCellValue("project_sns_code");
        row.createCell(3).setCellValue("code");


        for (int i = 0; i < dmEntities.size(); i++) {
            dmEntity dmEntity = dmEntities.get(i);
            HSSFRow rows = hssfSheet.createRow(i + 1);
            rows.createCell(0).setCellValue(dmEntity.getTech_name());
            rows.createCell(1).setCellValue(dmEntity.getIcv());
            rows.createCell(2).setCellValue(dmEntity.getProject_sns_code());
            rows.createCell(3).setCellValue(dmEntity.getCode());


        }
        try {
            FileOutputStream out = new FileOutputStream("D:\\项目文档\\dm.xls");
            hssfWorkbook.write(out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
