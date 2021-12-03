package com.example.demo;

import com.example.demo.dao.IOrderDao;
import com.example.demo.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/2 20:35
 **/
public class MybatisTest extends DemoApplicationTests {

    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void setUp() throws Exception{
        ClassPathResource resource = new ClassPathResource("mybatis-config.xml");
        InputStream inputStream = resource.getInputStream();
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectUserTest(){
        int id = 12;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);
        Order order = iOrderDao.getOrderById(id);
        sqlSession.close();
    }
}
