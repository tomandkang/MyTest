package com.example.testservice;

import com.example.testapi.dto.BaseEntityDTO;
import com.example.testapi.dto.UserDTO;
import com.example.testapi.es.TestUserEs;
import com.example.testservice.boot.TestServiceApplication;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    private static Integer i = 1;

    private static final UserDTO userDTO = new UserDTO();

    public static Integer reverse(int num) {
        return ~(num - 1);
    }

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public static void main(String[] args) {

        Integer reverse = reverse(50);
        System.out.println(reverse);

        if (Objects.nonNull(args)) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }
    }

    @Test
    public void test() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2024-08-29 19:34:41");
        Date parse1 = sdf.parse("2024-07-29 19:34:41");
        Date parse2 = sdf.parse("2024-06-29 19:34:41");
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

}