package com.myexcemple.utils;

import com.myexcemple.entity.FilesPath;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SimpleExcelWrite {

    public static void creatExcel(List<FilesPath> filesPaths) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");

        HSSFRow row = hssfSheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("created_date");
        row.createCell(2).setCellValue("last_modified_date");
        row.createCell(3).setCellValue("is_active");
        row.createCell(4).setCellValue("is_delete");
        row.createCell(5).setCellValue("remark");
        row.createCell(6).setCellValue("code");
        row.createCell(7).setCellValue("name");
        row.createCell(8).setCellValue("parent_id");
        row.createCell(9).setCellValue("temp_id");
        row.createCell(10).setCellValue("created_by_id");
        row.createCell(11).setCellValue("last_modified_by_id");
        row.createCell(12).setCellValue("sns");
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        List list4 = new ArrayList();
        List list5 = new ArrayList();
        List list6 = new ArrayList();
        String idsss0 = "-1";
        String idsss1 = "";
        String idsss2 = "";
        String idsss3 = "";
        String idsss4 = "";
        String idsss5 = "";
        String idsss6 = "";
        for (int i = 0; i < filesPaths.size(); i++) {
            FilesPath filesPath = filesPaths.get(i);
            int sum = filesPath.getSum() + 1;
            HSSFRow rows = hssfSheet.createRow(i + 1);
            rows.createCell(sum).setCellValue(filesPath.getFileName());

            String codes = "";
            switch (filesPath.getSum()) {
                case 1:
                    list1.add(1);
                    idsss1 = "-1";
                    list2.clear();
                    list3.clear();
                    list4.clear();
                    list5.clear();
                    list6.clear();
                    break;
                case 2:
                    list2.add(1);
                    list3.clear();
                    list4.clear();
                    list5.clear();
                    list6.clear();
                    System.out.println("2");
                    break;
                case 3:
                    list3.add(1);
                    list4.clear();
                    list5.clear();
                    list6.clear();
                    System.out.println("3");
                    break;
                case 4:
                    list4.add(1);
                    list5.clear();
                    list6.clear();
                    System.out.println("4");
                    break;
                case 5:
                    list5.add(1);
                    list6.clear();
                    System.out.println("5");
                    break;
                case 6:
                    list6.add(1);
                    System.out.println("6");
                    break;
            }
            String codes1111 = "";
            String codes2222 = "";

            if (list1.size() < 10) {
                codes1111 += "0" + list1.size();
                codes2222 += "c0" + list1.size();
            } else if (list1.size() < 100) {
                codes1111 += list1.size();
                codes2222 += "c" + list1.size();
            }
            if (list2.size() < 10) {
                codes1111 += "0" + list2.size();
                codes2222 += "-0" + list2.size();
            } else if (list2.size() < 100) {
                codes1111 += list2.size();
                codes2222 += "-" + list2.size();
            }
            if (list3.size() < 10) {
                codes1111 += "0" + list3.size();
                codes2222 += "-0" + list3.size();
            } else if (list3.size() < 100) {
                codes1111 += list3.size();
                codes2222 += "-" + list3.size();
            }
            if (list4.size() < 10) {
                codes1111 += "0" + list4.size();
                codes2222 += "0" + list4.size();
            } else if (list4.size() < 100) {
                codes1111 += list4.size();
                codes2222 += list4.size();
            }
            if (list5.size() < 10) {
                codes1111 += "0" + list5.size();
                codes2222 += "-0" + list5.size();
            } else if (list5.size() < 100) {
                codes1111 += list5.size();
                codes2222 += "-" + list5.size();
            }
            if (list6.size() < 10) {
                codes1111 += "0" + list6.size() + "0";
                codes2222 += "0" + list6.size();
            } else if (list6.size() < 100) {
                codes1111 += "0" + list6.size();
                codes2222 += list6.size();
            }

            rows.createCell(0).setCellValue(codes1111);
            rows.createCell(1).setCellValue("2021/6/17 15:53:16");
            rows.createCell(2).setCellValue("2021/6/17 15:53:16");
            rows.createCell(3).setCellValue("1");
            rows.createCell(4).setCellValue("0");
            rows.createCell(5).setCellValue("");
            rows.createCell(6).setCellValue(codes1111);
            rows.createCell(7).setCellValue(filesPath.getFileName());

            rows.createCell(9).setCellValue("4028eedc7a177872017a18f428ba018d");
            rows.createCell(10).setCellValue("user-admin-user");
            rows.createCell(11).setCellValue("user-admin-user");
            rows.createCell(12).setCellValue(codes2222);

//            idsss = codes1111;
            switch (filesPath.getSum()) {
                case 1:
                    rows.createCell(8).setCellValue("-1");
                    idsss1 = codes1111;
                    break;
                case 2:
                    rows.createCell(8).setCellValue(idsss1);
                    idsss2 = codes1111;
                    break;
                case 3:
                    rows.createCell(8).setCellValue(idsss2);
                    idsss3 = codes1111;
                    break;
                case 4:
                    rows.createCell(8).setCellValue(idsss3);
                    idsss4 = codes1111;
                    break;
                case 5:
                    rows.createCell(8).setCellValue(idsss4);
                    idsss5 = codes1111;
                    break;
                case 6:
                    rows.createCell(8).setCellValue(idsss5);
                    break;
            }
        }
        try {
            FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xls");
            hssfWorkbook.write(out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
