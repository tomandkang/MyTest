package com.example.demo.TestClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/2/19 15:13
 **/

public class Test5Class {
    private static final TimeZone timeZone = TimeZone.getTimeZone("ISO 8601");

    public static void main(String[] args) throws Exception{
        String str="2019-10-10T00:57:03.0954";
        Date iso8601Date = getISO8601Date(str);
        Date date = addMinute(iso8601Date, -5);
        String iso8601YMDTHMS = getISO8601YMDTHMS(date);
        System.out.println(iso8601YMDTHMS);
    }

    public static Date addMinute(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, amount);
        return calendar.getTime();
    }


    public static Date getISO8601Date(String dataStr)throws Exception{
        SimpleDateFormat formatYMDTHM = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        formatYMDTHM.setTimeZone(timeZone);
        return formatYMDTHM.parse(dataStr);
    }

    public static String getISO8601YMDTHMS(Date date){
        SimpleDateFormat formatYMDTHM = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        formatYMDTHM.setTimeZone(timeZone);
        return formatYMDTHM.format(date);
    }
}
