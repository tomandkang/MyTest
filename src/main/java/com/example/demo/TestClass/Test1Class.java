package com.example.demo.TestClass;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/4/1 11:24
 **/
public class Test1Class {
    private static final int POOL_SIZE = 5;

    private static final Logger LOGGER = LogManager.getLogger(Test1Class.class);

    private static final ThreadPoolExecutor pool= new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE,
            0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
       // LocalDateTime now = LocalDateTime.now();
      //  System.out.println(now);
        String status="closed1";
        if(!"closed".equals(status)&&!"paused".equals(status)){
            System.out.println("呵呵");
        }
    }

    public void test(){
        String name = this.getClass().getName();
        System.out.println(name);
    }

    private static void push2redis(Long shopAccountId,Map<String, String> cbtMap,List<String> itemIds) {
        Map<String, Object> map= new HashMap<>();
        map.put("shopAccountId",shopAccountId);
        map.put("cbtMap",cbtMap);
        map.put("itemIds",itemIds);
        map.clear();
        itemIds.clear();
        cbtMap.clear();
        map.clear();
    }
}
