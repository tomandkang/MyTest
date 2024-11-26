package com.example.testservice;

import com.alibaba.fastjson.JSON;
import com.example.testapi.dto.BaseEntityDTO;
import com.example.testapi.dto.UserDTO;
import com.example.testapi.es.TestUserEs;
import com.example.testcommon.entity.Constant;
import com.example.testservice.boot.TestServiceApplication;
import com.example.testservice.utils.DateUtils;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: chenkangwen
 * @CreateTime: 2023-08-10  10:29
 * @Description:
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestServiceApplication.class)
@EnableAutoConfiguration
public class CommonTest {

    private static final UserDTO userDTO = new UserDTO();

    private static final String REGEXP = "runoob";

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public static void main(String[] args) {
        // 取反
        System.err.println(~Constant.NUMBER_STATUS_ZERO);
        // 取反
        System.err.println(~Constant.NUMBER_STATUS_TEN);

        if (Objects.nonNull(args)) {
            for (int i = 0; i < args.length; i++) {
                System.err.println(args[i]);
            }
        }
        userDTO.setUserName("测试");
        userDTO.setAge(18);
        System.out.println(JSON.toJSONString(userDTO));

    }

    @Test
    public void test() {
        Date now = DateUtils.parseDate("2024-07-29 19:34:41");
        System.out.println(now);
    }

    @Test
    public void test_1() {
        List<? extends BaseEntityDTO> list = new ArrayList<>();
        List<? super BaseEntityDTO> baseEntityDTOS = new ArrayList<>();
    }

    /**
     * @description: es
     * @author: chenkangwen
     * @date: 2024/11/7
     * @param: []
     */
    @Test
    public void test_2() {
        TestUserEs testUserEs = new TestUserEs();
        testUserEs.setId(20L);
        testUserEs.setName("xixihaha");
        testUserEs.setAge(30);
        testUserEs = elasticsearchRestTemplate.save(testUserEs);

    }


    @Test
    public void test_3() {
        String str = "Google runoob taobao runoob";
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(str);

        String s = matcher.replaceAll("nonono");


        System.out.println(matcher.find());
        System.out.println(s);
    }

}