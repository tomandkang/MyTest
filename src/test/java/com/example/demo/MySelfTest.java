package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IUserMapper;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/14 16:00
 **/
public class MySelfTest extends DemoApplicationTests {

    @Autowired
    private IUserMapper iUserMapper;

    @Test
    public void test_a_1(){
        User user = new User();
        user.setId(10);
        user.setName("ckw");
        iUserMapper.insert(user);
    }
    @Test
    public void test_a_2(){

        User user = iUserMapper.selectUser("HGJHGJGH");
        System.out.println(JSON.toJSONString(user));
    }
}
