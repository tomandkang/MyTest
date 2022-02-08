package com.example.demo.commom.ObjectTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2022/1/6 18:25
 **/
public class Mytest_2 {

    public static void main(String[] args)throws Exception{
        List<Son> list = new ArrayList<>();
        for (Long i=0L;i<10L;i++){
            Son son = new Son();
            son.setId(i);
            son.setName("张三"+i);
            son.setAge(18);
            son.setSchool("小比崽子"+i);
            list.add(son);
        }

        Long id = list.stream().max(Comparator.comparingLong(Son::getId)).get().getId();
      //  Long id = list.stream().map(e -> e.getId()).sorted(Comparator.reverseOrder()).findFirst().orElse(0L);
        System.out.println(id);


    }
}
