package com.example.demo.entity;

public class Father {

    private Boolean hasWife;


    public Boolean getHasWife() {
        return hasWife;
    }

    public void setHasWife(Boolean hasWife) {
        this.hasWife = hasWife;
    }

    public Father() {
        System.out.println("父类无参数构造");
    }

    public Father(Boolean hasWife) {
        this.hasWife = hasWife;
        System.out.println("父类有参数构造");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public void say(){
        System.out.println("这个是父类");
    }

    public static String eat(){
        return "父类吃肉";
    }
}
