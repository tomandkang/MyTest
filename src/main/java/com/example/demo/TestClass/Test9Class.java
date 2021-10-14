package com.example.demo.TestClass;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/20 14:15
 **/
public class Test9Class {


    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        //封装日志记录
        JSONObject contentJson = new JSONObject();
        contentJson.put("singleAttribute","singleAtrreibute");
        contentJson.put("sku","hello");
        contentJson.put("qty",12);
        contentJson.put("price",89.9);
        contentJson.put("promotionalPrice",88);
        jsonArray.add(contentJson);
        System.out.println(JSON.toJSONString(jsonArray));
    }
}
