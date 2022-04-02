package com.example.demo;

import com.example.demo.dao.IOrderDao;
import com.example.demo.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
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
    private SqlSession sqlSession;


    //这个SqlSessionFactoryBuilder类的存在很简单,取名也叫他构建器,Mybatis的官网是这样解释它的,
    //这个类可以被实例化(因为它有且仅有一个默认的无参构造),
    //使用它的目的就是用来创建多个SqlSessionFactory实例,
    //最好不要让他一直存在,进而保证所有用来解析xml的资源可以被释放
    @Before
    public void setUp() throws Exception {
        ClassPathResource resource = new ClassPathResource("mybatis-config.xml");
        InputStream inputStream = resource.getInputStream();
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectUserTest() {
        String id = "123456";
        sqlSession = sqlSessionFactory.openSession();
        IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);
        Order order = iOrderDao.getOrderById(id);
        System.out.println(order);
        sqlSession.commit();
        sqlSession.close();
    }

    @After
    public void setDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

}
