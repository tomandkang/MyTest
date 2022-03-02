package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IGoodDao;
import com.example.demo.dao.IOrderDao;
import com.example.demo.entity.Good;
import com.example.demo.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/14 16:00
 **/
public class MySelfTest extends DemoApplicationTests {

   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Autowired
    private IGoodDao iGoodDao;
    @Autowired
    private IOrderDao iOrderDao;



    @Test
    public void test_1(){
        Good good = iGoodDao.getGoodById(1);
        System.err.println(JSON.toJSONString(good));
    }

    @Test
    public void test_2(){
        Good good = new Good();
        good.setId(3);
        good.setGoodName("chenkangwen1");
        good.setCreater("chenkangwen1");
        good.setCreateDate(new Date());
        iGoodDao.insertGood(good);

    }

    @Test
    public void test_3(){
        List<Good> goodList = iGoodDao.getGoodList();
        System.err.println(JSON.toJSONString(goodList));

    }


    @Test
    public void test_4(){
        Order order = iOrderDao.getOrderById(1);
        System.out.println(JSON.toJSONString(order));
    }

    @Test
    public void test_5(){

        //Date parse = sdf.parse("2019-01-10 19:32:58");
        Order order = new Order();
        order.setId(2);
        order.setOrderNo(2);
        order.setOrderTime(new Date());
        order.setCreater("chenkangwen1");
        order.setOrderContent("chenkangwen1");
        iOrderDao.insertOrder(order);
    }

    @Test
    public void test_6(){
        List<Order> orderList = iOrderDao.getOrderList();
        System.err.println(JSON.toJSONString(orderList));
    }
}
