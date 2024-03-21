package com.example.demo.entity;

import com.example.demo.commom.annotation.MyAnnotation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Father {

   public final static Map<String, Integer> awardStockMap = new ConcurrentHashMap<>(); // 奖品 <--> 奖品库存

    static {
        //获取redis库中的内容
        awardStockMap.put("1", 10);//1000积分
        awardStockMap.put("2",20);//500积分
        awardStockMap.put("3", 30);//300积分
        awardStockMap.put("4",50);//100~200积分区间
        awardStockMap.put("未中奖", 60); //
        //权重默认等于库存
    }

    @MyAnnotation
    private Boolean hasWife;


    public Boolean getHasWife() {
        return hasWife;
    }

    public void setHasWife(Boolean hasWife) {
        this.hasWife = hasWife;
    }

    public Father() {
    }

    public Father(Boolean hasWife) {
        this.hasWife = hasWife;

    }

    static {

    }

    {

    }

    public void say(){
        System.out.println("这个是父类");
    }

    public static String eat(){
        return "父类吃肉";
    }
}
