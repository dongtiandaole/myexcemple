package com.media;

import com.media.entity.t_project_media;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class WriteDmMedia {
    public static void creatExcel(List<t_project_media> t_project_mediaList) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");

        HSSFRow row = hssfSheet.createRow(0);
        row.createCell(0).setCellValue("dm_id");
        row.createCell(1).setCellValue("media_code");



        for (int i = 0; i < t_project_mediaList.size(); i++) {
            t_project_media pdfs = t_project_mediaList.get(i);
            HSSFRow rows = hssfSheet.createRow(i + 1);
            rows.createCell(0).setCellValue(pdfs.getDm_id());
            rows.createCell(1).setCellValue(pdfs.getMedia_code());
        }
        try {
            FileOutputStream out = new FileOutputStream("D:\\项目文档\\t_project_dm_medias.xls");
            hssfWorkbook.write(out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
