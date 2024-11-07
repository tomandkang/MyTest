package com.example.testcommon.commom.mode.factoryMode;

// 客户端代码
public class Client {

    public static void main(String[] args) {

        Creator creatorA = new ConcreteCreatorA();

        Creator creatorB = new ConcreteCreatorB();

        Product productA = creatorA.factoryMethod();

        Product productB = creatorB.factoryMethod();

        productA.operation();

        productB.operation();

    }

}
