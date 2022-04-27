package com.example.demo;

import com.example.demo.commom.proxy.cglibDynamicProxy.CglibProxyFactory;
import com.example.demo.commom.proxy.cglibDynamicProxy.User;
import com.example.demo.commom.proxy.jdkDynamicProxy.SuperMarketInvocationHandler;
import com.example.demo.commom.proxy.staticProxy.ExpressCompanyProxy;
import com.example.demo.commom.proxy.staticProxy.SuperMarket;
import com.example.demo.commom.proxy.staticProxy.SuperMarketAction;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyTest extends DemoApplicationTests {


    @Test
    public void test() {
        SuperMarket superMarket = new SuperMarket();
        ExpressCompanyProxy proxy = new ExpressCompanyProxy(superMarket);
        proxy.deliverGoods();
    }

    @Test
    public void test_1() {
        // 创建要被代理的类
        SuperMarketAction superMarketAction = new SuperMarket();
        // 创建要被代理类的处理方式
        SuperMarketInvocationHandler invocationHandler = new SuperMarketInvocationHandler(superMarketAction);
        // 创建代理对象
        SuperMarketAction proxy = (SuperMarketAction) Proxy.newProxyInstance(superMarketAction.getClass().getClassLoader(), superMarketAction.getClass().getInterfaces(), invocationHandler);
        // 通过代理对象进行调用
        proxy.deliverGoods();
    }

    @Test
    public void test_2(){
        User user = new User();
        User proxy = (User) new CglibProxyFactory(user).getProxyInstance();
        proxy.say("hello world");
    }

}
