package com.horvat.bll.helpers;

import com.horvat.dal.FileManager;
import com.horvat.dl.entities.Doctor;
import com.lib.xml.XmlReader;
import com.lib.xml.XmlTag;

import java.util.*;
import java.util.function.Function;

public class Utils {
    public static final String DATE_FORMAT = "dd.MM.yyyy.";
    public static final String DATE_WITH_TIME_FORMAT = "dd.MM.yyyy. HH:mm:ss";

    private static final String xmlFilePath = FileManager.getFilePath("OMM_Settings.xml");
    private static final XmlTag settingTag = new XmlTag("Settings");
    private static XmlReader reader;

    public static String getXmlSetting(String key) {
        try {
            if (reader == null)
                reader = new XmlReader(xmlFilePath);

            Map<String, List<String>> xmlData = reader.getXMLData(settingTag, new XmlTag(key));

            List<String> data = xmlData.get(key);
            return data.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean dateWithin(DateWithin option, Date date) {
        //set min to 00:00 of today (this covers DateWithin.TODAY)
        Calendar min = new GregorianCalendar();
        min.set(Calendar.HOUR_OF_DAY, 0);
        min.set(Calendar.MINUTE, 0);
        min.set(Calendar.SECOND, 0);
        min.set(Calendar.MILLISECOND, 0);

        //set max to 00:00 of tomorrow (Date.before will exclude it)
        Calendar max = new GregorianCalendar();
        max.setTime(min.getTime());
        max.add(Calendar.DAY_OF_YEAR, 1);

        switch (option) {
            case THIS_WEEK:
                min.add(Calendar.WEEK_OF_YEAR, -1);
                break;
            case THIS_MONTH:
                min.add(Calendar.MONTH, -1);
                break;
        }

        //Subtract a millisecond so that Date.after can cover 00:00
        //(goes to 23:59:59.999 of previous day, but Date.after will
        // correctly exclude it and look from 00:00 on)
        min.add(Calendar.MILLISECOND, -1);

        return date.after(min.getTime()) && date.before(max.getTime());
    }

    public static <K, V> Object[][] convertToObjectArray(Map<K, V> map) {
        return convertToObjectArray(map, K::toString, V::toString);
    }

    public static <K, V> Object[][] convertToObjectArray(
            Map<K, V> map,
            Function<K, Object> keyToObjectConverter,
            Function<V, Object> valueToObjectConverter
    ) {
        if (map == null || map.size() == 0)
            return null;

        Object[][] objectArray = new Object[map.size()][];
        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i] = new Object[2];

            int counter = 0;
            for (K key : map.keySet()) {
                if (counter++ == i) {
                    V value = map.get(key);

                    objectArray[i][0] = keyToObjectConverter.apply(key);
                    objectArray[i][1] = valueToObjectConverter.apply(value);

                    break;
                }
            }
        }

        return objectArray;
    }
}
