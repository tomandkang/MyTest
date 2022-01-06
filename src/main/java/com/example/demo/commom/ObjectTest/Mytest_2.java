package com.example.demo.commom.ObjectTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2022/1/6 18:25
 **/
public class Mytest_2 {

    public static void main(String[] args)throws Exception{
        List<Son> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Son son = new Son();
            son.setName("张三");
            son.setAge(18);
            son.setSchool("小比崽子");
            list.add(son);
        }




    }
}
