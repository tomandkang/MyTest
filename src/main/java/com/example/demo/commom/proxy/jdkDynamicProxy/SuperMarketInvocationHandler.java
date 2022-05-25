package com.example.demo.commom.proxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SuperMarketInvocationHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object superMarket;
    /**
     * 构造函数
     * @param superMarket
     */
    public SuperMarketInvocationHandler(Object superMarket) {
        this.superMarket = superMarket;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类调用委托类方法之前");
        Object result = method.invoke(superMarket, args);
        System.out.println("代理类调用委托类方法之后");
        return result;
    }
}
