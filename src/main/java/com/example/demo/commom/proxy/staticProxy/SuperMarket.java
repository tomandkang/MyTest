package com.example.demo.commom.proxy.staticProxy;

public class SuperMarket implements SuperMarketAction {


    @Override
    public void deliverGoods() {
        System.out.println("SuperMarket.deliverGoods()");
    }
}
