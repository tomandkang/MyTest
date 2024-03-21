package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Father;
import com.example.demo.entity.UserDTO;
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

    public static void main(String[] args) throws Exception {
        System.out.println(~30);
        System.out.println(reverse(30));
    }

    public static Integer reverse(int num) {
        return ~(num - 1);
    }

    @Test
    public void test() {
        final UserDTO userDTO = new UserDTO();
        userDTO.setName("你真的笑死个人");
        // userDTO = new UserDTO();
        System.out.println(userDTO.getName());


    }

    @Test
    public void test1() {
        String join = StringUtils.join(1, "");
        System.out.println(join);
        System.out.println(new String().equals(""));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{5, 0, 6, 7, 3, 9, 1, 4};
        int[] index = new int[]{6, 0, 2, 1, 3, 6, 7, 0, 2, 5, 4};
        String tel = "";
        for (int i : index) {
            tel += arr[1];
        }
        System.out.println("联系方式:" + tel);
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
    public void test5() {
        int i = new Father().hashCode();
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
    public void test7() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xixi", new Father(true));
        resultMap.put("HEHE", null);

        Map<String, Object> map = new HashMap<>();
        map.put("hello", "hello");
        map.put("hehe", resultMap);


        Map<String, Object> o = (Map<String, Object>) map.get("hehe");
        Father xixi = (Father) o.get("HEHE");
        System.out.println(JSON.toJSONString(xixi));

        new Thread(() -> {

        }).start();

        new Thread() {

        };
    }

    @Test
    public void test8() {
        Map<String, String> map = new HashMap<>();
        map.put("","");

    }
}