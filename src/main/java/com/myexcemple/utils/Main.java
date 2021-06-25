package com.myexcemple.utils;

import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        transLateEMBS12();
    }

    private static int totalCount = 0;
    private static int pdfTotalCount = 0;
    private static int svgTotalCount = 0;
    private static int skipFileCount = 0;
    private static String logFilePath = "D:\\temp\\IETMLogs\\";
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    //    上海地铁12号线内容转换
    private static void transLateEMBS12() {
        String logFileName = System.currentTimeMillis() + ".log";
        createFile(logFilePath + logFileName);
        saveLog("----------------------------------start---------------------------------", false);
        String rootPath = "D:\\EMBS12_002";
        String filePath = "\\routes\\query\\file\\SML12EXP";
        String dataPath = "\\routes\\query\\file\\SML12EXP";
        String resultPath = "D:\\workspace\\CBRC\\SML12EXP";
        String dataModulePath = "\\dm";
        String externalFilePath = "\\external";

        File rootFile = new File(rootPath + filePath);
        if (!rootFile.exists()) {
            String log = "无法找到目录文件：" + rootPath + filePath;
            saveLog(log, true);
            return;
        }
        File dataFile = new File(rootPath + dataPath);
        if (!dataFile.exists()) {
            String log = "无法找到目录文件：" + rootPath + dataPath;
            saveLog(log, true);
            return;
        }
        listFiles(rootFile, dataFile);
        saveLog("转换完成", false);
        saveLog("文件总计：" + totalCount, false);
        saveLog("pdf文件：" + pdfTotalCount, false);
        saveLog("图解类文件：" + svgTotalCount, false);
        saveLog("跳过文件：" + skipFileCount, false);
        saveLog("----------------------------------end---------------------------------", false);
    }

    private static void createFilePath(String path) {
        File file = new File(path);
        if (file.exists()) {
            return;
        } else {
            String log = "创建文件夹" + path;
            file.mkdirs();
            saveLog(log, false);
        }
    }

    private static void createFile(String filePath) {
        File file = new File(filePath);
        File dirctFile = file.getParentFile();
        if (!dirctFile.exists()) {
            dirctFile.mkdirs();
        }
        if (!file.exists()) {
            try {
                System.out.println(file.getAbsolutePath());
                file.createNewFile();
                logFilePath = filePath;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listFiles(File rootFile, File dataFile) {
        File[] subFiles = rootFile.listFiles();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                if (subFile.isDirectory()) {
                    listFiles(subFile, dataFile);
                } else {
                    saveLog("----------------------------------------------------------", false);
                    totalCount++;
                    if (subFile.getName().toLowerCase().endsWith(".pdf")) {
                        pdfTotalCount++;
                        transPdfFile(subFile);
                    } else if (subFile.getName().toLowerCase().endsWith(".svg")) {
                        svgTotalCount++;
                        transIPDInfo(subFile);
                    } else {
                        skipFileCount++;
                        saveLog("跳过文件：" + subFile.getName(), false);
                        saveLog("文件路径：" + subFile.getAbsolutePath(), false);
                    }
                }
            }
        }
    }

    private static void transPdfFile(File pdfFile) {
        saveLog("开始转换PDF文件：" + pdfFile.getName(), false);
        saveLog("文件地址：" + pdfFile.getAbsolutePath(), false);
        if (!pdfFile.exists()) {
            saveLog("无法找到文件" + pdfFile.getAbsolutePath(), true);
            return;
        }
        System.out.println("拷贝并重命名");
    }

    private static void transIPDInfo(File svgFile) {
        saveLog("开始转换图解零部件：" + svgFile.getName(), false);
        saveLog("文件地址：" + svgFile.getAbsolutePath(), false);
    }

    private static void saveLog(String log, boolean err) {

        log = df.format(new Date()) + ":" + (err ? "错误：" : "：") + log;
        saveAsFileWriter(log);
        if (err) {
            System.err.println(log);
        } else {
            System.out.println(log);
        }
    }

    private static void saveAsFileWriter(String content) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(logFilePath, true);
            fwriter.write(content + "\r\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
