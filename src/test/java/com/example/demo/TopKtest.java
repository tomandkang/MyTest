package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Son;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKtest extends DemoApplicationTests {


    @Test
    public void test() {
        final Son son = new Son();
        son.setHasWife(false);
        System.out.println(JSON.toJSONString(son));
    }


    @Test
    public void test1() {
        String str = "哈哈哈";
        List<String> list = new ArrayList<>(Arrays.asList(str));
        list.add("呵呵呵");

        list.forEach(e->{
            System.err.println(e);
        });
    }
}
