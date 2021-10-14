package com.example.demo.TestClass;

import com.example.demo.ObjectTest.Father;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/10 10:04
 **/
public class ReflectClass {


    public static void main(String[] args) {
        Father father = new Father();
        father.setName("陈康文");
        father.setAge(20);
        father.setDate("2021/5/10");


        Class<? extends Father> fatherClass = father.getClass();


    }

}
