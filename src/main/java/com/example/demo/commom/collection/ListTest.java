package com.example.demo.commom.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
      String str="{\"data\":{\"platformCode\":\"Walmart\",\"skus\":[\"A301\",\"A306\"],\"basicId\":\"1000622\",\"profitsRate\":15,\"discountRate\":null,\"type\":2,\"ifManual\":0},\"ticket\":\"ff5d368bdb1faee41d8dc8de00d417af\",\"operator\":\"chenkangwen1\",\"personName\":\"陈康文\",\"funcVersion\":\"910498e1483716f0538e479c716e1d4d\",\"moduleUrl\":\"/publish/salespricing/domesticwarehouse/\",\"requestId\":\"061009074376153925c8f621bdae7f95\",\"deviceName\":\"Chrome浏览器\"}";
        JSONObject jsonObj =JSON.parseObject(str);
        JSONObject dataObj = jsonObj.getJSONObject("data");
        String platform = dataObj.getString("platformCode");
        String basicId = dataObj.getString("basicId");
        Float profitsRate = dataObj.getFloat("profitsRate");
        String discountRate = dataObj.getString("discountRate");
        String skus = dataObj.getString("skus");
        Integer shipmentType = dataObj.getInteger("shipmentType");
        System.out.println(JSON.toJSONString(skus));
        System.out.println(shipmentType);


    }

    public static void test(){
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO("西施", 18));
        list.add(new UserDTO("王昭君", 16));
        list.add(new UserDTO("杨昭君", 20));
        list.add(new UserDTO("貂蝉", 24));
        list.add(new UserDTO("猪八戒", 5));
        Collections.sort(list, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                //第一个参数属性 - 第二个参数属性 = 升序排序
                //第二个参数属性 - 第一个参数属性 = 降序排序
                int num = o2.getAge() - o1.getAge();
                if (num > 0) {
                    return 1;
                } else if (num < 0) {
                    return -1;
                }
                return 0;
            }
        });
        System.err.println(JSON.toJSONString(list));
    }
}
