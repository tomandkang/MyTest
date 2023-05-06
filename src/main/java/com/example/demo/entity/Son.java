package com.example.demo.entity;

import lombok.Data;

@Data
public class Son extends Father{

    private String name;

    private String age;


    static {
    }

    {

    }

    public Son() {
    }

    public Son(Boolean hasWife) {
        super(hasWife);
    }

    public Son(String name,String age){
        this.name=name;
        this.age=age;
    }

    @Override
    public void say(){
        System.out.println("这个是子类");
    }

    public static String eat(){
        return "儿子喝奶粉";
    }

}
