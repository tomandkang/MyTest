package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.dao.IOrderDao;
import com.example.demo.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/2 20:35
 **/
public class MybatisTest extends DemoApplicationTests {

    private SqlSessionFactory sqlSessionFactory;

    private static final String AUTO_PUSH_SHIELD_PLATFORM="[\"Amazon\",\"Wish\",\"EBay\",\"Shopee\",\"B2W\",\"Lazada\"]";

    @Before
    public void setUp() throws Exception{
        ClassPathResource resource = new ClassPathResource("config/mybatis-config.xml");
        InputStream inputStream = resource.getInputStream();
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectUserTest(){
        String orderId="1234";
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);
        Order order = iOrderDao.getOrderById(orderId);
        sqlSession.close();
    }

    @Test
    public void test_1(){
        Class classes=Order.class;
        String name = classes.getName();
        System.out.println(name);
    }
}
