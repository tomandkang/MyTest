package com.example.demo.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.concurrent.Executor;

@RestController
public class RedisController {

    @Autowired
    private Jedis jedis;

    @Autowired
    private Executor executor;

    @RequestMapping("/hello")
    public String test(){
        for(int i=0;i<5;i++){
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        return "SUCCESS"  ;
    }


}
