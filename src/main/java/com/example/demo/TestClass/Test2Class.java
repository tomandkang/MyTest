package com.example.demo.TestClass;

import com.alibaba.fastjson.JSON;
import com.example.demo.ObjectTest.Father;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test2Class{


    public static void main(String[] args) {

        List<String> list = Arrays.asList("111","222","333",null);
        //符合表达式要求的数据
        List<String> collect = list.stream().filter(x ->x!=null&&x.equals("333")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    public static void recursion(int count){
        if(count<=0){
            return;
        }
        try {
            int i=1/0;
        }catch (ArithmeticException e){
            System.err.println(e);
            recursion(--count);
        }

    }


    public  void test1(){
        DecimalFormat format = new DecimalFormat("0.00");
        String abc ="100.456";
        String a = format.format(new BigDecimal(abc));
        System.out.println(a);
    }

/*
    public void test2(){
        TreeSet<Father> taskTopVos = new TreeSet<>(new Comparator<Father>() {
            @Override
            public int compare(Father o1, Father o2) {
                return (int)(o2.getDate().getTime()-o1.getDate().getTime());
            }
        });
        taskTopVos.add(new Father("张三",new Date(1516703796507l)));
        taskTopVos.add(new Father("李四",new Date(1516703796522l)));
        taskTopVos.add(new Father("王五",new Date(1516713796522l)));

        List<Father> list = new ArrayList<>();
        list.addAll(taskTopVos);
        list.forEach(e-> {
            System.out.println(JSON.toJSONString(e));
        });
    }*/


    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(null);
        int size = list.size();
        int offSet =2;
        int i=0;
        if (size <= 10) {
            while (0 < size) {
                List<String> subList = null;
                size = list.size();
                if (offSet> size) {
                    subList = list.subList(0, size);
                } else {
                    subList = list.subList(0, offSet);
                }
                if (CollectionUtils.isEmpty(subList)) {
                    break;
                }
                subList.forEach(e -> {
                    System.out.println(e);
                });
                subList.clear();
            }
        }
    }

}
