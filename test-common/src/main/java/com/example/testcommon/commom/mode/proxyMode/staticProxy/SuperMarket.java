package com.example.testcommon.commom.mode.proxyMode.staticProxy;

public class SuperMarket implements SuperMarketAction {


    @Override
    public void deliverGoods() {
        System.out.println("SuperMarket.deliverGoods()");
    }
}
