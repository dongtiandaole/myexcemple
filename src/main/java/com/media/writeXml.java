package com.media;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class writeXml {
    public static void creat(Document document, String name) {
        // 增加文档
//        Document document = (Document) DocumentHelper.createDocument();
//        // 增加Element: parent.addElement("childName");
//        Element root = document.addElement("userlist");
//        // 增加Attribute addAttribute("属性名","属性值")
//        Element user1 = root.addElement("user");
//        user1.addAttribute("id", "100");
//        Element username = user1.addElement("username");
//        username.setText("小周");
//        Element password = user1.addElement("password");
//        password.setText("admin");


        // 写入文件
        XMLWriter xmlWriter = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("D:\\outXml\\"+name));

            // 设置输出格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");

            // 创建writer(参数一：输出流，参数二L：输出格式)
            xmlWriter = new XMLWriter(fos, format);
            // 写数据
            xmlWriter.write(document);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                fos.close();
                xmlWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
