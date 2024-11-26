package com.example.testcommon.commom.mode.factoryMode;

// 具体工厂A
public class ConcreteCreatorA extends Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
