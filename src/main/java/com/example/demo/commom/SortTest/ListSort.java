package com.example.demo.commom.SortTest;

import com.alibaba.fastjson.JSON;
import com.example.demo.commom.ObjectTest.Son;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/22 15:52
 **/
public class ListSort {

    public static void main(String[] args) throws Exception{
        List<Son> queues = new ArrayList<>();
        Son son = new Son();
        son.setAge(1);
        son.setName("张三");
        son.setCreateTime(new Date());

        Thread.sleep(1000);

        Son son1 = new Son();
        son1.setAge(2);
        son1.setName("李四");
        son1.setCreateTime(new Date());


        queues.add(son1);
        queues.add(son);

        Collections.sort(queues, new Comparator<Son>() {
            @Override
            public int compare(Son o1, Son o2) {
                if(o1.getCreateTime().before(o2.getCreateTime())){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        queues.forEach(e->System.out.println(JSON.toJSONString(e)));
    }
}
