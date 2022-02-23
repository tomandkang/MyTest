package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IOrderDao;

import com.example.demo.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChenTest extends DemoApplicationTests  {



    @Autowired
    private IOrderDao iOrderDao;

    @Test
    public void test()throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = sdf.parse("2019-01-10 19:32:58");

        Order order = new Order();
        order.setId(1);
        order.setOrderContent("chenkangwen");
        order.setOrderNo(1);
        order.setOrderTime(new Date());


        Order order1 = new Order();
        order1.setId(2);
        order1.setOrderContent("chen");
        order1.setOrderNo(2);
        order1.setOrderTime(parse);

        iOrderDao.insertOrder(order);
        iOrderDao.insertOrder(order1);
    }

    @Test
    public void test_1()throws Exception{
        List<Order> list = iOrderDao.getOrderList();
        System.out.println(JSON.toJSONString(list));
    }

}
