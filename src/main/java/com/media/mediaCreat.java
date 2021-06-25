package com.media;

import com.media.entity.dmEntity;
import com.media.entity.t_project_media;
import com.myexcemple.entity.FilesPath;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class mediaCreat {
    private int sums = 0;
    List<medias> pdfsList = new ArrayList<>();
    List<t_project_media> t_project_mediaList = new ArrayList<>();
    List<dmEntity> dmEntities = new ArrayList<>();
    List lev1 = new ArrayList();
    List lev2 = new ArrayList();
    List lev3 = new ArrayList();
    List lev4 = new ArrayList();
    List lev5 = new ArrayList();
    List lev6 = new ArrayList();

    @Test
    public void test() {
        this.EncryptFile("D:\\EMBS12_002\\routes\\query\\file\\SML12EXP");
//        WriteExcel.creatExcel(pdfsList);
//        WriteExcel2.creatExcel(dmEntities);
        WriteDmMedia.creatExcel(t_project_mediaList);
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
                        getSums(sums);
                        getAllSums(sums);
                        if(".svg".equals(suffix)){
                            getSums(sums);
                            getAllSums(sums);
                            String sns = getSns();
                            medias pdfs = new medias();
                            String rename = getCodes(sums,sns);
                            pdfs.setCode(rename);
                            rename+=".svg";
                            pdfs.setName(names);
                            pdfs.setSns(sns);
                            pdfs.setRename(rename);
                            pdfsList.add(pdfs);

                            String path1 = fList[j].getPath();
                            String[] AllPath = path1.split("\\\\");
                            String techNames = AllPath[AllPath.length-1];

                            String snsCode = "c"+sns.substring(0,2)+"-"+sns.substring(2,4)+"-"+sns.substring(4,8)+"-"+sns.substring(8,12);
                            dmEntity dmEntity = new dmEntity();
                            dmEntity.setTech_name(techNames);

                            String madiaCode = rename.substring(0,rename.lastIndexOf("."));
                            int sums = Integer.valueOf(madiaCode.substring(madiaCode.length()-14,madiaCode.length()-9))+1;
                            String icvs = loadText.numberToLetter(sums);
                            dmEntity.setIcv(icvs);
                            dmEntity.setProject_sns_code(snsCode);

                            String dmCode = "DMC-AA-A-"+sns.substring(0,2)+"-"+sns.substring(2,6)+"-"+sns.substring(6,8)+"-"+sns.substring(8,12)+"A-943"+loadText.numberToLetter(sums)+"-D_000-00_zh-CN";
                            dmEntity.setCode(dmCode);
                            dmEntities.add(dmEntity);

                            t_project_media t_project_media = new t_project_media();
                            t_project_media.setMedia_code(madiaCode);
                            t_project_media.setDm_id(dmCode);
                            t_project_mediaList.add(t_project_media);

                            String pdfPath = fList[j].getPath();
                            String newPath = "D:\\项目文档\\svg";
//                            CopyFile.copy(pdfPath, newPath,rename);
                            String paths[] = pdfPath.split("\\\\");
                            String path2 =paths[0]+"\\"+paths[1]+"\\"+paths[2]+"\\queryparts"+"";
                            for(int sss = 4;sss<paths.length;sss++){
                                path2 +="\\"+paths[sss];
                            }
                            path2 = path2.substring(0,path2.lastIndexOf("."));
//                            CopyFile.copy(pdfPath, newPath,rename);
                            path2+=".txt";
                            loadText.traverseFolder(path2,sns,names,rename);
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
                        if(".svg".equals(suffix)){
                            medias pdfs = new medias();
                            getAllSums(sums);
                            String sns = getSns();
                            String rename = getCodes(sums,sns);
                            pdfs.setCode(rename);
                            rename+=".svg";
                            pdfs.setName(names);
                            pdfs.setSns(sns);
                            pdfs.setRename(rename);
                            pdfsList.add(pdfs);
                            String path1 = fList[j].getPath();
                            String[] AllPath = path1.split("\\\\");
                            String techNames = AllPath[AllPath.length-1];

                            String snsCode = "c"+sns.substring(0,2)+"-"+sns.substring(2,4)+"-"+sns.substring(4,8)+"-"+sns.substring(8,12);
                            dmEntity dmEntity = new dmEntity();
                            dmEntity.setTech_name(techNames);

                            String madiaCode = rename.substring(0,rename.lastIndexOf("."));
                            int sums = Integer.valueOf(madiaCode.substring(madiaCode.length()-14,madiaCode.length()-9))+1;
                            String icvs = loadText.numberToLetter(sums);
                            dmEntity.setIcv(icvs);
                            dmEntity.setProject_sns_code(snsCode);
                            String dmCode = "DMC-AA-A-"+sns.substring(0,2)+"-"+sns.substring(2,6)+"-"+sns.substring(6,8)+"-"+sns.substring(8,12)+"A-943"+loadText.numberToLetter(sums)+"-D_000-00_zh-CN";
                            dmEntity.setCode(dmCode);
                            dmEntities.add(dmEntity);

                            t_project_media t_project_media = new t_project_media();
                            t_project_media.setMedia_code(madiaCode);
                            t_project_media.setDm_id(dmCode);
                            t_project_mediaList.add(t_project_media);

                            String pdfPath = fList[j].getPath();
                            String newPath = "D:\\项目文档\\svg";
                            String paths[] = pdfPath.split("\\\\");
                            String path2 =paths[0]+"\\"+paths[1]+"\\"+paths[2]+"\\queryparts";
                            for(int sss = 4;sss<paths.length;sss++){
                                path2 +="\\"+paths[sss];
                            }
                            path2 = path2.substring(0,path2.lastIndexOf("."));
//                            CopyFile.copy(pdfPath, newPath,rename);
                            path2+=".txt";
                            loadText.traverseFolder(path2,sns,names,rename);
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
        String code = "ICN-AA-A-"+sns+"-A-CBRC-";
        int i = 0;
        for(medias pdfs:pdfsList){
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
