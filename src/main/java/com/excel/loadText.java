package com.excel;


import com.media.writeXml;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.DocumentType;
import org.dom4j.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class loadText {


    public static void traverseFolder(String path,String sns,String names,String rename) {
            File files = new File(path);

        if (files.exists()) {
            readStudentTxt(files,sns,names,rename);
        } else {
            System.out.println(path);
            System.out.println("文件不存在!");
        }
    }

    /**
     * *********  读取文本方法  *********
     *
     * @param file 读取传递过来的文件
     */
    public static void readStudentTxt(File file,String sns,String names,String rename) {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(isr);
            StringBuffer resposeBuffer = new StringBuffer("");
            String lineTxt = null;
            String madiaCode = rename.substring(0,rename.lastIndexOf("."));
            int sums = Integer.valueOf(madiaCode.substring(madiaCode.length()-14,madiaCode.length()-9))+1;

            while ((lineTxt = br.readLine()) != null) {
                lineTxt = new String(lineTxt.getBytes(), "utf-8");
                lineTxt = getJson(lineTxt);

                JSONArray jsonArray = JSONArray.fromObject(lineTxt);


                Document document = (Document) DocumentHelper.createDocument();



                Element dmodule = document.addElement("dmodule");
                dmodule.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
                dmodule.addAttribute("xmlns:dc","http://www.purl.org/dc/elements/1.1/");
                dmodule.addAttribute("xmlns:rdf","http://www.w3.org/1999/02/22-rdf-syntax-ns#");
                dmodule.addAttribute("xmlns:xlink","http://www.w3.org/1999/xlink");
                dmodule.addAttribute("xsi:noNamespaceSchemaLocation","http://www.s1000d.org/S1000D_4-1/xml_schema_flat/ipd.xsd");

                Element identAndStatusSection = dmodule.addElement("identAndStatusSection");

                Element dmAddress = identAndStatusSection.addElement("dmAddress");
                Element dmIdent = dmAddress.addElement("dmIdent");

                Element dmCode = dmIdent.addElement("dmCode");
                dmCode.addAttribute("modelIdentCode","AA");
                dmCode.addAttribute("systemDiffCode","A");
                String systemCode = sns.substring(0,2);
                dmCode.addAttribute("systemCode",systemCode);
                String subSystemCode = sns.substring(2,4);
                dmCode.addAttribute("subSystemCode",subSystemCode);
                String subSubSystemCode = sns.substring(4,6);
                dmCode.addAttribute("subSubSystemCode",subSubSystemCode);
                String assyCode = sns.substring(6,8);
                dmCode.addAttribute("assyCode",assyCode);
                String disassyCode = sns.substring(8,12);
                dmCode.addAttribute("disassyCode",disassyCode);

                dmCode.addAttribute("disassyCodeVariant","A");
                dmCode.addAttribute("infoCode","941");
                String infoCodeVariant = numberToLetter(sums);
                dmCode.addAttribute("infoCodeVariant",infoCodeVariant);
                dmCode.addAttribute("itemLocationCode","D");

                Element language = dmIdent.addElement("language");
                language.addAttribute("languageIsoCode","zh");
                language.addAttribute("countryIsoCode","CN");

                Element issueInfo = dmIdent.addElement("issueInfo");
                issueInfo.addAttribute("issueNumber","000");
                issueInfo.addAttribute("inWork","00");

                Element dmAddressItems = dmAddress.addElement("dmAddressItems");
                Element issueDate = dmAddressItems.addElement("issueDate");
                issueDate.addAttribute("year","2021");
                issueDate.addAttribute("month","5");
                issueDate.addAttribute("day","22");

                String path1 = file.getPath();
                String[] AllPath = path1.split("\\\\");
                String techNames = AllPath[AllPath.length-2];

                Element dmTitle = dmAddressItems.addElement("dmTitle");
                Element techName = dmAddressItems.addElement("techName");
                techName.setText(techNames);

                Element infoName = dmTitle.addElement("infoName");
                infoName.setText("图解零部件数据");


                Element dmStatus = identAndStatusSection.addElement("dmStatus");
                dmStatus.addAttribute("issueType","changed");
                Element security = dmStatus.addElement("security");
                security.addAttribute("securityClassification","01");
                security.addAttribute("commercialClassification","cc51");
                security.addAttribute("caveat","cv51");
                Element responsiblePartnerCompany = dmStatus.addElement("responsiblePartnerCompany");
                responsiblePartnerCompany.addAttribute("enterpriseCode","CRBC");
                Element enterpriseName = responsiblePartnerCompany.addElement("enterpriseName");
                enterpriseName.setText("长客庞巴迪");
                Element originator = dmStatus.addElement("originator");
                originator.addAttribute("enterpriseCode","CRBC");
                Element enterpriseName1 = originator.addElement("enterpriseName");
                enterpriseName1.setText("长客庞巴迪");
                Element applic = dmStatus.addElement("applic");
                Element displayText = applic.addElement("displayText");
                Element simplePara = displayText.addElement("simplePara");

                Element brexDmRef = dmStatus.addElement("brexDmRef");
                Element dmRef = brexDmRef.addElement("dmRef");
                Element dmRefIdent = dmRef.addElement("dmRefIdent");
                Element dmCode1 = dmRefIdent.addElement("dmCode");
                dmCode1.addAttribute("modelIdentCode","");
                dmCode1.addAttribute("systemDiffCode","");
                dmCode1.addAttribute("systemCode","");
                dmCode1.addAttribute("subSystemCode","");
                dmCode1.addAttribute("subSubSystemCode","");
                dmCode1.addAttribute("assyCode","");
                dmCode1.addAttribute("disassyCode","");
                dmCode1.addAttribute("disassyCodeVariant","");
                dmCode1.addAttribute("infoCode","");
                dmCode1.addAttribute("infoCodeVariant","");
                dmCode1.addAttribute("itemLocationCode","");

                Element qualityAssurance = dmStatus.addElement("qualityAssurance");
                Element unverified = qualityAssurance.addElement("unverified");

                Element content = dmodule.addElement("content");

                Element illustratedPartsCatalog = content.addElement("illustratedPartsCatalog");

                Element figure = illustratedPartsCatalog.addElement("figure");
                Element title = figure.addElement("title");
                String name = names.substring(0, names.lastIndexOf("."));
                title.setText(name);

                Element graphic = figure.addElement("graphic");
                graphic.addAttribute("xlink:type", "simple");
                graphic.addAttribute("xlink:actuate", "onRequest");
                graphic.addAttribute("xlink:show", "new");
                graphic.addAttribute("xlink:href", "URN:S1000D:" + madiaCode);
                graphic.addAttribute("xlink:title", "Bicycle");
                graphic.addAttribute("infoEntityIdent", madiaCode);


                for(int i=0; i<jsonArray.size(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    Element catalogSeqNumber = illustratedPartsCatalog.addElement("catalogSeqNumber");
                    catalogSeqNumber.addAttribute("figureNumber","01");
                    catalogSeqNumber.addAttribute("indenture","1");
                    catalogSeqNumber.addAttribute("item","");

                    String id1 = object.getString("id");

                    Element itemSeqNumber = catalogSeqNumber.addElement("itemSeqNumber");
                    itemSeqNumber.addAttribute("itemSeqNumberValue",id1);

                    Element quantityPerNextHigherAssy = itemSeqNumber.addElement("quantityPerNextHigherAssy");

                    Element partRef = itemSeqNumber.addElement("partRef");
                    partRef.addAttribute("manufacturerCodeValue","");
                    partRef.addAttribute("partNumberValue","");

                    Element partSegment = itemSeqNumber.addElement("partSegment");

                    Element itemIdentData = partSegment.addElement("itemIdentData");

                    String duscription1 = object.getString("duscription");
                    Element descrForPart = itemIdentData.addElement("descrForPart");
                    descrForPart.setText(duscription1);

                    String partstand1 = object.getString("partstand");
                    Element limitedPartNumber = itemIdentData.addElement("limitedPartNumber");
                    limitedPartNumber.setText(partstand1);

                    String materialcode1 = object.getString("materialcode");
                    Element customerStockNumber = itemIdentData.addElement("customerStockNumber");
                    customerStockNumber.setText(materialcode1);


                    Element techData = partSegment.addElement("techData");
                    String unit1 = object.getString("unit");
                    Element unitOfIssue = techData.addElement("unitOfIssue");
                    unitOfIssue.setText(unit1);




                    Element genericPartDataGroup = itemSeqNumber.addElement("genericPartDataGroup");

                    String weight1 = object.getString("weight");
                    Element genericPartData1 = genericPartDataGroup.addElement("genericPartData");
                    genericPartData1.addAttribute("genericPartDataName","weight");
                    Element genericPartDataValue1 = genericPartData1.addElement("genericPartDataValue");
                    genericPartDataValue1.setText(weight1);

                    String remark1 = object.getString("remark");
                    Element genericPartData2 = genericPartDataGroup.addElement("genericPartData");
                    genericPartData2.addAttribute("genericPartDataName","remark");
                    Element genericPartDataValue2 = genericPartData2.addElement("genericPartDataValue");
                    genericPartDataValue2.setText(remark1);

                    String quantityA1 = object.getString("quantityA");
                    Element genericPartData3 = genericPartDataGroup.addElement("genericPartData");
                    genericPartData3.addAttribute("genericPartDataName","quantityA");
                    Element genericPartDataValue3 = genericPartData3.addElement("genericPartDataValue");
                    genericPartDataValue3.setText(quantityA1);

                    String quantityB1 = object.getString("quantityB");
                    Element genericPartData4 = genericPartDataGroup.addElement("genericPartData");
                    genericPartData4.addAttribute("genericPartDataName","quantityB");
                    Element genericPartDataValue4 = genericPartData4.addElement("genericPartDataValue");
                    genericPartDataValue4.setText(quantityB1);


                    String quantityC1 = object.getString("quantityC");
                    Element genericPartData5 = genericPartDataGroup.addElement("genericPartData");
                    genericPartData5.addAttribute("genericPartDataName","quantityC");
                    Element genericPartDataValue5 = genericPartData5.addElement("genericPartDataValue");
                    genericPartDataValue5.setText(quantityC1);

                    String quantityD1 = object.getString("quantityD");
                    Element genericPartData6 = genericPartDataGroup.addElement("genericPartData");
                    genericPartData6.addAttribute("genericPartDataName","quantityD1");
                    Element genericPartDataValue6 = genericPartData6.addElement("genericPartDataValue");
                    genericPartDataValue6.setText(quantityC1);
                }
                String filesname = "DMC-AA-A-"+sns.substring(0,2)+"-"+sns.substring(2,6)+"-"+sns.substring(6,8)+"-"+sns.substring(8,12)+"A-943"+numberToLetter(sums)+"-D_000-00_zh-CN.xml";
                String docTypeStr = "dmodule[";
                docTypeStr += "\n<!ENTITY "+madiaCode+" SYSTEM \""+rename+"\" NDATA svg>";
                docTypeStr += "]";
                document.addDocType("","","");
                DocumentType docType = document.getDocType();

                docType.setElementName(docTypeStr);
                writeXml.creat(document,filesname);

            }
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getJson(String jsonStr) {
        if (jsonStr != null && jsonStr.startsWith("\ufeff")) {
             jsonStr = jsonStr.substring(1);
//            jsonStr = jsonStr.substring(jsonStr.indexOf("{"),
//                    jsonStr.lastIndexOf("}")+1);
        }

//        return str_json;
        return jsonStr;
    }
 public static String numberToLetter(int num) {
   if (num <= 0) {
     return null;
   }
   String letter = "";
   num--;
   do {
     if (letter.length() > 0) {
       num--;
     }
     letter = ((char) (num % 26 + (int) 'A')) + letter;
     num = (int) ((num - num % 26) / 26);
   } while (num > 0);

   return letter;
 } 
}
