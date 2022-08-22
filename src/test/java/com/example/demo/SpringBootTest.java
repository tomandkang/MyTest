package com.example.demo;

import com.example.demo.entity.TestA;
import com.example.demo.entity.TestB;
import com.example.demo.entity.TestC;
import com.example.demo.entity.TestD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SpringBootTest extends DemoApplicationTests {

    @Test
    public void test1() throws Exception{
        System.out.println(TestB.class);
        System.out.println(new TestB().getClass());
        System.out.println(Class.forName("com.example.demo.entity.TestB"));
    }


    @Test
    public void testImport(){
      /*  AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("====="+name);
        }*/
        StringBuffer synResult = new StringBuffer();
    }
    @Autowired
    TestA testA;

    @Autowired
    TestB testB;

    @Autowired
    TestC testC;

    @Autowired
    TestD testD;

    @Test
    public void TestD() {
        testD.printName();
    }

    @Test
    public void TestC() {
        testC.printName();
    }

    @Test
    public void TestB(){
        testB.printName();
    }

    @Test
    public void testA(){
        testA.printName();
    }

    @Test
    public void test1314(){
       // String[] split = "22/08/15".split("\\/");
       // System.out.println(split[0]+"-"+split[1]+"-"+split[2]);
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new Date());//设置当前日期
        String yearStr = calendar.get(Calendar.YEAR) + "";//获取年份
        String yearPrefix = yearStr.substring(0,2);
        System.out.println(yearPrefix);
        //System.out.println(yearStr);
    }
    @Test
    public void test13145(){
        List<String> list= new ArrayList<>();
        list.add("hehe");
        list.add("haihai");
        System.out.println(String.join(",",list));
    }


}
