package com.example.demo;

import com.example.demo.commom.proxy.staticProxy.ExpressCompanyProxy;
import com.example.demo.commom.proxy.staticProxy.SuperMarket;
import org.junit.jupiter.api.Test;

public class ProxyTest extends DemoApplicationTests{


    @Test
    public void test(){
        SuperMarket superMarket = new SuperMarket();
        ExpressCompanyProxy proxy = new ExpressCompanyProxy(superMarket);
        proxy.deliverGoods();
    }
}
