package com.example.testcommon.commom.mode.factoryMode;

// 具体产品A
public class ConcreteProductA implements Product {

    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}
