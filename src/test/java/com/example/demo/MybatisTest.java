package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.IOrderDao;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.Order;
import com.sun.istack.internal.NotNull;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/2 20:35
 **/
public class MybatisTest extends DemoApplicationTests {

    private SqlSessionFactory sqlSessionFactory;

    private static final String AUTO_PUSH_SHIELD_PLATFORM="[\"Amazon\",\"Wish\",\"EBay\",\"Shopee\",\"B2W\",\"Lazada\"]";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

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

    //创建文档
    @Test
    public void test_2() throws Exception{
        Commodity commodity = new Commodity();
        commodity.setCommodityId(3L);
        commodity.setCommodityName("hahaha");
        commodity.setPictureUrl("www.google.com");
        commodity.setPrice(5.20F);

        BulkRequest bulkAddRequest = new BulkRequest();
        IndexRequest indexRequest =getIndexRequest("commodityId","commodity", "onsale",commodity);
        bulkAddRequest.add(indexRequest);
        restHighLevelClient.bulk(bulkAddRequest);
    }

    @NotNull
    private IndexRequest getIndexRequest(String primary, String index, String type, Object o) throws Exception {
        String id = getFieldValueByFieldName(primary, o);
        String data = null;
        try {
            data = JSONObject.toJSONString(o);
        } catch (Exception e) {
            throw new Exception(e);
        }
        IndexRequest indexRequest = new IndexRequest(index, type, id);
        indexRequest.source(data, XContentType.JSON);
        return indexRequest;
    }

    public static String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //对private的属性的访问
            field.setAccessible(true);
            return field.get(object) == null ? null : field.get(object).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
