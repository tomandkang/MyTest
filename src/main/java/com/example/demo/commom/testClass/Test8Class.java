package com.example.demo.TestClass;


import com.example.demo.ObjectTest.Father;
import com.example.demo.SpringContextUtils.SpringContextUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/3/1 18:07
 **/
public class Test8Class {


    public static void main(String[] args) {

        try {
            testz51();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testz51()throws Exception{
        Date startDate = new Date(1621872000000L);
        Date endDate = new Date(1622476799000L);
        List<String> columnNum = getColumnNum(startDate, endDate);
        columnNum.forEach(e->{
            System.out.println(e);
        });

    }

    private static List<String> getColumnNum(Date startDate, Date endDate) {
        List<String> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        while(calendar.getTime().before(endDate)){
            list.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }
        return list;
    }

}
