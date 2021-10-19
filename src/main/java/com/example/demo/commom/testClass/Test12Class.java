package com.example.demo.commom.testClass;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/18 19:57
 **/
public class Test12Class {

    public static void main(String[] args) {
        List<Integer> accounts = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19);
        int num = 19;
        int offset = 0;
        List<Integer> list = null;
        while (num > offset) {
            if (offset + 3 > num) {
                list = accounts.subList(offset, num);
                offset = num;
            } else {
                list = accounts.subList(offset, offset + 3);
                offset = offset + 3;
            }
            System.out.println(JSON.toJSONString(list));
        }
    }
}
