package com.example.testservice.commom.proxy.staticProxy;

public class ExpressCompanyProxy implements SuperMarketAction {

    private SuperMarket superMarket;
    public ExpressCompanyProxy(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }
    /**
     * 代理类执行操作 - 寄快递,相当于超市将物品发给物流公司，由物流公司进行分发到各个人手中。
     */
    @Override
    public void deliverGoods() {
        System.out.println("代理类调用委托类方法之前");
        superMarket.deliverGoods();
        System.out.println("代理类调用委托类方法之后");
    }
}
