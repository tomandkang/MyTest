package com.example.testcommon.commom.mode.factoryMode;

// 具体工厂B
public class ConcreteCreatorB extends Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
