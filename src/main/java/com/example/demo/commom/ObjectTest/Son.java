package com.example.demo.commom.ObjectTest;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Son extends Father{


    private Integer age;

    private String name;

    private String school;

    public Son() {
        super();
    }

    public static void main(String[] args) {
        Map<String, Son> map = new HashMap<>();
        Son son = new Son();
        son.setSchool("xiaoxue");
        son.setAge(18);
        son.setName("kangkang");
        map.put("0",son);
        
        Son son1 = new Son();
        son1.setSchool("daxue");
        son1.setAge(18);
        son1.setName("kangwen");
        map.put("1",son1);

        System.out.println(JSON.toJSONString(new ArrayList<>(map.values())));

    }

    /**
     * 获取 某天 的零点时间
     *
     * @param days 与当前时间相差的天数
     * @return 某天 的零点时间
     * @author tangfudong
     */
    public static Date getZeroTime(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }




    public static Date getZeroTime(Date date,int hour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date addSecond(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, num);
        return calendar.getTime();
    }

    public Son(Integer age, String name1, String school) {
        this.age = age;
        this.name = name1;
        this.school = school;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
