package com.myexcemple.utils;

import com.myexcemple.entity.FilesPath;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IOWrite {
    private int sums = 0;

    List<FilesPath> filesPaths = new ArrayList<>();

    @Test
    public void test() {
        this.EncryptFile("D:\\EMBS12_002\\routes\\query\\file\\SML12EXP");

        SimpleExcelWrite.creatExcel(filesPaths);
    }

    public void EncryptFile(String path) {
        sums++;
        File f = new File(path);
        if (f.isDirectory()) {//判断当前对象是否是目录
            File[] fList = f.listFiles();//获取目录下文件列表
            int count = fList.length;
            String code1 = "";
            if (sums == 1) {

                for (int j = 0; j < count; j++) {
                    FilesPath filesPath = new FilesPath();

                    if (fList[j].isDirectory()) {//判断当前对象是否是目录
                        System.out.println(fList[j].getName());
                        filesPath.setFileName(fList[j].getName());
                        filesPath.setSum(sums);

                        filesPaths.add(filesPath);
                        this.EncryptFile(path + "\\" + fList[j].getName());//若为目录则递归

                    } else {
                        String names = fList[j].getName();
                        int dot = names.lastIndexOf('.');
                        names = names.substring(0, dot);
                        filesPath.setFileName(names);
                        filesPath.setSum(sums);

                        filesPaths.add(filesPath);

                    }
                }
            } else {
                for (int j = 0; j < count; j++) {
                    if (fList[j].isDirectory()) {//判断当前对象是否是目录
                        System.out.println(fList[j].getName());
                        FilesPath filesPath = new FilesPath();
                        filesPath.setFileName(fList[j].getName());
                        filesPath.setSum(sums);
                        filesPaths.add(filesPath);
                        this.EncryptFile(path + "\\" + fList[j].getName());//若为目录则递归

                    }
                }
            }
            sums--;
        }
    }
}
