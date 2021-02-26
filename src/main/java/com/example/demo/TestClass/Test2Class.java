package com.example.demo.TestClass;

import com.alibaba.fastjson.JSON;
import com.example.demo.ObjectTest.Father;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test2Class {


    public static void main(String[] args) {
        recursion(1);
    }

    public static void recursion(int count){
        if(count<0){
            return;
        }
        try {
            System.out.println("递归调用异常");
            int i=1/0;
        }catch (ArithmeticException e){
            System.err.println(e);
            recursion(--count);
        }

    }

}
