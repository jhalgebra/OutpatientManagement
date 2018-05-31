package com.horvat.bll.helpers;

import com.horvat.dal.FileManager;
import com.lib.xml.XmlReader;
import com.lib.xml.XmlTag;

import java.util.List;
import java.util.Map;

public class Utils {
    private static final String xmlFilePath = FileManager.getFilePath("OMM_Settings.xml");
    private static final XmlTag settingTag = new XmlTag("Settings");
    private static XmlReader reader;

    public static String getXmlSetting(String key) {
        try {
            if(reader == null)
                reader = new XmlReader(xmlFilePath);

            Map<String, List<String>> xmlData = reader.getXMLData(settingTag, new XmlTag(key));

            List<String> data = xmlData.get(key);
            return data.get(0);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
