package com.example.demo.commom.testClass;

import com.alibaba.fastjson.JSON;
import com.example.demo.commom.ObjectTest.Father;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/2/27 15:16
 **/
public class Test7Class {

    private static List<Father> accountSkuList = new ArrayList<>();

    static {
        Father father = new Father();
        father.setAge(1);
        father.setName("陈康文");
        accountSkuList.add(father);
        Father father1 = new Father();
        father1.setAge(2);
        father1.setName("陈康文");
        accountSkuList.add(father1);
        Father father2 = new Father();
        father2.setAge(3);
        father2.setName("陈康文");
        accountSkuList.add(father2);
        Father father3 = new Father();
        father3.setAge(4);
        father3.setName("陈康文");
        accountSkuList.add(father3);
        Father father4 = new Father();
        father4.setAge(5);
        father4.setName("陈康文");
        accountSkuList.add(father4);
        Father father5 = new Father();
        father5.setAge(6);
        father5.setName("陈康文");
        accountSkuList.add(father5);
        
    }


    public static void main(String[] args) {
        
        while(accountSkuList!=null&&accountSkuList.size()>0){
            List<Father> fathers=null;
            if(accountSkuList.size()>4){
                fathers = accountSkuList.subList(0, 4);
            }else{
                fathers = accountSkuList.subList(0,accountSkuList.size());
            }
            for (Father father :fathers){
                father.setName("OK");
            }


            fathers.clear();
        }

        System.out.println(JSON.toJSONString(accountSkuList));
        

    }




}
