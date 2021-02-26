package com.example.demo.TestClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/2/23 14:37
 **/
public class Test6Class {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int i=0;i<3;i++){
            list.remove(0);
        }
        list.forEach(x->
                System.out.println(x)
        );
    }
}
