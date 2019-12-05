package com.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class _DateTool {


    /**
     * Convertit un string au format date Date
     * Tue Feb 06 09:16:17 GMT 2018 (yyyy-MM-dd HH:mm:)
     * @param dateString
     * @return
     * @throws java.text.ParseException 
     */
    public static Date stringToDate(String dateString) throws java.text.ParseException{
        //format android
        String expectedFormat = "yyyy-MM-dd HH:mm:ss";
        return stringToDate(dateString,expectedFormat);
    }

    /**
     * Convertit un string au format date au format souhaité
     * @param dateString
     * @param expectedFormat
     * @return
     * @throws java.text.ParseException 
     */
    public static Date stringToDate(String dateString, String expectedFormat) throws java.text.ParseException{
        SimpleDateFormat format = new SimpleDateFormat(expectedFormat);
        try {
            Date date = format.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convertit une date au format string en format Date 2018-02-06 09:16:17
     * @param d
     * @return
     */
    public static String dateToString(Date d){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date.format(d);
    }

    /**
     * Arrondir à 2 virgule
     * @param value
     * @return
     */
    public static String format2Decimal(float value){
        return String.format("%.01f", value);
    }

}
