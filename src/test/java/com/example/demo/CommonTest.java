package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenkangwen
 * @CreateTime: 2023-08-10  10:29
 * @Description:
 * @Version: 1.0
 */
public class CommonTest extends DemoApplicationTests {

    private static Integer i = 1;


    public Integer reverse(int num) {
        return ~(num - 1);
    }

    @Test
    public void test1() {
        String join = StringUtils.join(1, "");
        System.out.println(join);
        System.out.println(new String().equals(""));
    }



    @Test
    public void test3() {
        String str = "master SELECT t.id AS 'value',t.real_name AS 'label' FROM t_user t WHERE t.del_flag=0 AND t.`master`=1 AND t.`master`=1 AND t.role_id=1607081635265834181 AND t.office_id= ?";
        //非法字符
        String[] keywords = {"master", "truncate", "insert", "delete", "update", "declare", "alert", "drop"};
        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                int i = str.split(keyword).length - 1;
                int j = str.split(StringUtils.join("`", keyword, "`")).length - 1;

                throw new RuntimeException("包含非法字符");
            }
        }
    }

    @Test
    public void test4() {
        int i = BigDecimal.ZERO.compareTo(new BigDecimal("0"));
        System.out.println(i);
    }

    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        System.out.println(JSON.toJSONString(list));
    }


    @Test
    public void test8() {
        Map<String, String> map = new HashMap<>();
        map.put("","");

    }
}