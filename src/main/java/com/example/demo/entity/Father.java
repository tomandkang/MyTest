package com.example.demo.entity;

import com.example.demo.commom.annotation.MyAnnotation;

public class Father {

    @MyAnnotation
    private Boolean hasWife;


    public Boolean getHasWife() {
        return hasWife;
    }

    public void setHasWife(Boolean hasWife) {
        this.hasWife = hasWife;
    }

    public Father() {
    }

    public Father(Boolean hasWife) {
        this.hasWife = hasWife;

    }

    static {

    }

    {

    }

    public void say(){
        System.out.println("这个是父类");
    }

    public static String eat(){
        return "父类吃肉";
    }
}
