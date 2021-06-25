package com.pdf.demo.exceple;

import com.myexcemple.entity.FilesPath;
import com.myexcemple.utils.CopyFile;
import com.pdf.demo.entity.pdfs;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class readIo {


    private int sums = 0;
    List<pdfs> pdfsList = new ArrayList<>();
    List lev1 = new ArrayList();
    List lev2 = new ArrayList();
    List lev3 = new ArrayList();
    List lev4 = new ArrayList();
    List lev5 = new ArrayList();
    List lev6 = new ArrayList();

    @Test
    public void test() {
        this.EncryptFile("D:\\EMBS12_002\\routes\\query\\file\\SML12EXP");

WriteExcel.creatExcel(pdfsList);
    }


    List AllSums1 = new ArrayList();
    List AllSums2 = new ArrayList();
    List AllSums3 = new ArrayList();
    List AllSums4 = new ArrayList();
    List AllSums5 = new ArrayList();
    List AllSums6 = new ArrayList();

    public void EncryptFile(String path) {
        sums++;
        File f = new File(path);
        if (f.isDirectory()) {//判断当前对象是否是目录
            File[] fList = f.listFiles();//获取目录下文件列表
            int count = fList.length;
                if(sums==1){
                    for (int j = 0; j < count; j++) {
                        FilesPath filesPath = new FilesPath();
                        if (fList[j].isDirectory()) {//判断当前对象是否是目录
                            System.out.println(fList[j].getName());
                            getSums(sums);
                            this.EncryptFile(path + "\\" + fList[j].getName());//若为目录则递归
                        } else {
                            String names = fList[j].getName();
                            int dot = names.lastIndexOf('.');
                            String suffix = names.substring(dot,names.length());
                            if(".pdf".equals(suffix)){
                                getSums(sums);
                                getAllSums(sums);
                                String sns = getSns();
                                pdfs pdfs = new pdfs();
                                String rename = getCodes(sums,sns);
                                pdfs.setCode(rename);
                                rename+=".pdf";
                                pdfs.setName(names);
                                pdfs.setSns(sns);
                                pdfs.setRename(rename);
                                pdfsList.add(pdfs);
                                String pdfPath = fList[j].getPath();
                                String newPath = "D:\\ietmGenFilePath\\file\\content\\project";
                                CopyFile.copy(pdfPath, newPath,rename);
                                System.out.println("");
                            }
                        }
                    }
                }else{
                    for (int j = 0; j < count; j++) {
                        FilesPath filesPath = new FilesPath();
                        if (fList[j].isDirectory()) {//判断当前对象是否是目录
                            System.out.println(fList[j].getName());
                            getSums(sums);
                            this.EncryptFile(path + "\\" + fList[j].getName());//若为目录则递归
                        } else {
                            String names = fList[j].getName();
                            int dot = names.lastIndexOf('.');
                            String suffix = names.substring(dot,names.length());
                            if(".pdf".equals(suffix)){
                                pdfs pdfs = new pdfs();
                                getAllSums(sums);
                                String sns = getSns();
                                String rename = getCodes(sums,sns);
                                pdfs.setCode(rename);
                                rename+=".pdf";
                                pdfs.setName(names);
                                pdfs.setSns(sns);
                                pdfs.setRename(rename);
                                pdfsList.add(pdfs);
                                String pdfPath = fList[j].getPath();
                                String newPath = "D:\\ietmGenFilePath\\file\\content\\project";
                                CopyFile.copy(pdfPath, newPath,rename);
                                System.out.println("");
                            }
                        }
                    }
                }


            }
            sums--;
        }


    public void getSums(int sums) {
        switch (sums) {
            case 1:
                lev1.add("0");
                lev2.clear();
                lev3.clear();
                lev4.clear();
                lev5.clear();
                lev6.clear();
                break;
            case 2:
                lev2.add("0");
                lev3.clear();
                lev4.clear();
                lev5.clear();
                lev6.clear();
                break;
            case 3:
                lev3.add("0");
                lev4.clear();
                lev5.clear();
                lev6.clear();
                break;
            case 4:
                lev4.add("0");
                lev5.clear();
                lev6.clear();
                break;
            case 5:
                lev5.add("0");
                lev6.clear();
                break;
            case 6:
                lev6.add("0");
                break;
        }
    }
    public void getAllSums(int sums) {
        switch (sums) {
            case 1:
                AllSums1.clear();
                AllSums1.add("0");
                AllSums2.clear();
                AllSums3.clear();
                AllSums4.clear();
                AllSums5.clear();
                AllSums6.clear();
                break;
            case 2:
                AllSums2.clear();
                AllSums2.add("0");
                AllSums3.clear();
                AllSums4.clear();
                AllSums5.clear();
                AllSums6.clear();
                break;
            case 3:
                AllSums3.clear();
                AllSums3.add("0");
                AllSums4.clear();
                AllSums5.clear();
                AllSums6.clear();
                break;
            case 4:
                AllSums4.clear();
                AllSums4.add("0");
                AllSums5.clear();
                AllSums6.clear();
                break;
            case 5:
                AllSums5.clear();
                AllSums5.add("0");
                AllSums6.clear();
                break;
            case 6:
                AllSums6.clear();
                AllSums6.add("0");
                break;
        }
    }

    public String getSns(){
        String code = "";
        if (lev1.size() < 10) {
            code += "0" + lev1.size();

        } else if (lev1.size() < 100) {
            code +=  lev1.size();

        }
        if (lev2.size() < 10) {
            code += "0" + lev2.size();

        } else if (lev2.size() < 100) {
            code +=  lev2.size();

        }
        if (lev3.size() < 10) {
            code += "0" + lev3.size();

        } else if (lev3.size() < 100) {
            code +=  lev3.size();

        }
        if (lev4.size() < 10) {
            code += "0" + lev4.size();

        } else if (lev4.size() < 100) {
            code +=  lev4.size();

        }
        if (lev5.size() < 10) {
            code += "0" + lev5.size();

        } else if (lev5.size() < 100) {
            code +=  lev5.size();

        }
        if (lev6.size() < 10) {
            code += "0" + lev6.size()+"0";

        } else if (lev6.size() < 100) {
            code += "0" +  lev6.size();

        }
        return code;
    }
    public String getCodes(int sums,String sns){
        String code = "EXT-AA-A-"+sns+"-A-CBRC-";
        int i = 0;
        for(pdfs pdfs:pdfsList){
            if(pdfs.getSns().equals(sns)){
                i++;
            }
        }
        if(i<10){
            code+="0000"+i;
        }else if(i<100){
            code+="000"+i;
        }else if(i<1000){
            code+="00"+i;
        }else if(i<10000){
            code+="0"+i;
        }else if(i<100000){
            code+=i;
        }



        code+="-A-000-01";
        return code;
    }
}
