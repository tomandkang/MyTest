package com.example.demo.ObjectTest;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Test {


    public static void main(String[] args) {

        try {
            try {
                firstTest();
            } catch (BussinesException e) {
                System.out.println("业务异常");
                return;
            }catch (Exception e) {
                System.out.println("你妈的");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("真的没想到");
            e.printStackTrace();
        }

    }

    public static void SecondTest(){

        firstTest();
        System.out.println("会不会执行");
    }



    public static void firstTest(){

        if(true){
            throw new BussinesException();
        }
        System.out.println("异常之后的代码");
    }
}
