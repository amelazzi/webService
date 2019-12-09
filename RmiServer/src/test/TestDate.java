package test;

import com.server.utils.DateTool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws Exception {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat();
        String DateToStr = format.format(curDate);
        System.out.println("Default pattern: " + DateToStr);

        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateToStr = format.format(curDate);
        System.out.println(DateToStr);

        Date strToDate = format.parse(DateToStr);
        System.out.println(strToDate);
    }
}
