package com.example.demo.entity;

import com.example.demo.commom.proxy.jdkDynamicProxy.SuperMarketInvocationHandler;
import com.example.demo.commom.proxy.staticProxy.SuperMarket;
import com.example.demo.commom.proxy.staticProxy.SuperMarketAction;

import java.lang.reflect.Proxy;

public class TestClass {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 创建要被代理的类
        SuperMarketAction superMarketAction = new SuperMarket();
        // 创建要被代理类的处理方式
        SuperMarketInvocationHandler invocationHandler = new SuperMarketInvocationHandler(superMarketAction);
        // 创建代理对象
        SuperMarketAction proxy = (SuperMarketAction) Proxy.newProxyInstance(superMarketAction.getClass().getClassLoader(), superMarketAction.getClass().getInterfaces(), invocationHandler);
        // 通过代理对象进行调用
        proxy.deliverGoods();
        /*
         * proxyClassName=com.java.proxy.$Proxy0
         */
        String proxyClassName = proxy.getClass().getName();

        System.out.println("proxyClassName="+proxyClassName);
    }
}
