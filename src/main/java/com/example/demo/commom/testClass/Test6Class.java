package com.example.demo.commom.testClass;

import com.alibaba.fastjson.JSONObject;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/2/23 14:37
 **/
public class Test6Class {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("22","22");
        System.out.println();
    }


    public static Date addMinute(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTime();
    }


}
