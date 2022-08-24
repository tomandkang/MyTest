package com.example.demo.commom.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy-MM-dd");


    public static String formatYMD(Date date) throws ParseException {
        synchronized (formatYMD) {
            return formatYMD.format(date);
        }
    }


    public static Date parseYMD(String strDate) throws ParseException {
        synchronized (formatYMD) {
            return formatYMD.parse(strDate);
        }
    }
    /**
     * @return
     * @Description 根据指定日期, 增加或者减少天数
     * @Author wuxin
     * @Param
     * @Version 2019/10/17 18:07
     */
    public static Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        return calendar.getTime();
    }

}
