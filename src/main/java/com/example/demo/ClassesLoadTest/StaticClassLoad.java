package com.example.demo.ClassesLoadTest;

public class StaticClassLoad extends NomalClassLoad{
    
    static {
        System.out.println("静态类静态代码块");
    }
    
    public StaticClassLoad() {
        System.out.println("静态类构造方法");
    }
    
    {
        System.out.println("静态类代码块");
    }

    public class StaticClassLoadSon{

    }

    public static void main(String[] args) {
        StaticClassLoad staticClassLoad = new StaticClassLoad();
    }
}
