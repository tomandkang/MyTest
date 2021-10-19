package com.example.demo.commom.testClass;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/7/5 16:19
 **/
public class Test10Class {

    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<>();
        Test10Class test10Class = new Test10Class();
        Class<? extends Test10Class> clazz = test10Class.getClass();
        Method method = clazz.getDeclaredMethod("getRandomOne",Set.class,int.class);
        method.invoke(test10Class,set,10);


    }

    public int getRandomOne(Set<Integer> set, int total){
        Random random = new Random();
        int size = set.size();
        while (true){
            int i = random.nextInt(total);
            set.add(i);
            if(set.size()>size){
                System.out.println(i);
                return i;
            }
        }
    }
}
