package com.example.demo.commom.newFeatures;

public interface NewCharacter {

    default void test(){
        System.out.println("jdk1.8新特性");
    }
}
