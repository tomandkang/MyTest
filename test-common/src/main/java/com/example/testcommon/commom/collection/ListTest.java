package com.example.testcommon.commom.collection;

import com.alibaba.fastjson.JSON;
import com.example.testapi.dto.UserDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        LinkedList<String> llt = new LinkedList<>();
        llt.add("hello");

        Vector<String> vector = new Vector<>();
        vector.add("hello");


        listSort();
        streamlistSort();
    }

    public static void listSort() {
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO("西施", 18));
        list.add(new UserDTO("王昭君", 16));
        list.add(new UserDTO("杨昭君", 20));
        list.add(new UserDTO("貂蝉", 24));
        list.add(new UserDTO("猪八戒", 5));
        list.add(new UserDTO("孙悟空", null));


        Collections.sort(list, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                //第一个参数属性 - 第二个参数属性 = 升序排序
                //第二个参数属性 - 第一个参数属性 = 降序排序
                int num = o2.getAge() - o1.getAge();
                if (num > 0) {
                    return 1;
                } else if (num < 0) {
                    return -1;
                }
                return 0;
            }
        });
        System.err.println(JSON.toJSONString(list));
    }


    public static void streamlistSort() {
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO("西施", 18));
        list.add(new UserDTO("王昭君", 16));
        list.add(new UserDTO("杨昭君", 20));
        list.add(new UserDTO("貂蝉", 24));
        list.add(new UserDTO("猪八戒", 5));
        list.add(new UserDTO("孙悟空", null));

        list = list.stream().sorted(Comparator.comparing(UserDTO::getAge, Comparator.nullsLast(Integer::compareTo)).reversed()).collect(Collectors.toList());
        for (UserDTO userDTO : list) {
            System.out.println(JSON.toJSONString(userDTO));
        }
    }
}
