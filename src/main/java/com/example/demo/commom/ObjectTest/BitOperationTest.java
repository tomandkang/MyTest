package com.example.demo.commom.ObjectTest;

public class BitOperationTest {

    public static void main(String[] args) {
        test_1();
    }

    //位移运算 int32位
    public static void test_1(){
        //0000 0000 0000 0000 0000 0000 0000 0001
        int i=1;
        System.out.println(i<<3);
        System.out.println(i>>3);
    }
}
