package com.example.demo.entity;

public class Son extends Father{


    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public Son() {
        System.out.println("子类无参数构造");
    }

    public Son(Boolean hasWife) {
        super(hasWife);
        System.out.println("子类有参数构造");
    }

    public void say(){
        System.out.println("这个是子类");
    }

    public static String eat(){
        return "儿子喝奶粉";
    }

}
