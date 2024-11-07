package com.example.testservice.controller;

import com.example.testapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

@RestController
public class RedisController {


    @Autowired
    private Executor executor;

    @RequestMapping("/hello/{id}")
    public String test(@PathVariable(name = "id") String id) {
        UserDTO userDTO = new UserDTO();
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        return "SUCCESS";
    }


}
