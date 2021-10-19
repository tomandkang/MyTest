package com.example.demo.controller;

import com.example.demo.commom.ObjectTest.Father;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.validation.Valid;
import java.util.concurrent.Executor;

@Controller
@RequestMapping(value="/test")
public class RedisController {

    @Autowired
    private Jedis jedis;

    @Autowired
    private Executor executor;

    @PostMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("123");
        for(int i=0;i<5;i++){
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        return "SUCCESS"  ;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String test1(@Valid @RequestBody Father father,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for (ObjectError allErrors :bindingResult.getAllErrors()){
                return  allErrors.getDefaultMessage();
            }
        }
        return "SUCCESS"  ;
    }
}
