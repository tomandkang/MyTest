package com.example.demo.commom.newFeatures;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Son;

public class Test<T> {




    public T getOne(T t){
        return t;
    }

    public static void main(String[] args) {
        Test<String> myTest = new Test<>();
        String str = myTest.getOne("haha");
        System.out.println(str);

        Test<Son> sonTest = new Test<>();
        Son son = sonTest.getOne(new Son("儿子", "20"));
        System.out.println(JSON.toJSONString(son));

    }

}
