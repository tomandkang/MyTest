package com.example.demo.commom.proxy.cglibDynamicProxy;

public class User {

    public String say(String msg){
        System.out.println("早上好"+msg);
        return  msg;
    }
}
