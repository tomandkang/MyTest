package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IGoodMapper;
import com.example.demo.entity.Good;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/14 16:00
 **/
public class MySelfTest extends DemoApplicationTests {

    @Autowired
    private IGoodMapper iGoodMapper;

    @Test
    public void test_1(){
        Good good = iGoodMapper.getGoodById(1);
        System.out.println(JSON.toJSONString(good));
    }

    @Test
    public void test_2(){
        Good good = new Good();
        good.setId(3);
        good.setGoodName("chenkangwen1");
        good.setCreater("chenkangwen1");
        good.setCreateDate(new Date());
        iGoodMapper.insertGood(good);

    }
}
