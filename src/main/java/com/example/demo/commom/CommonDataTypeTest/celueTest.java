package com.example.demo.commom.CommonDataTypeTest;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/27 12:03
 **/
public class celueTest {
   private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS
            , new ArrayBlockingQueue<>(1), new DefaultThreadFactory("QueueTest"),new ThreadPoolExecutor.DiscardPolicy());
   private static volatile Integer j=0;

    public static void main(String[] args) throws Exception {
        int i = new Random().nextInt(3);
        System.out.println(i);
    }


    public static void test(){
        IntStream.rangeClosed(1, 10).forEach(value -> {
            threadPoolExecutor.execute(()->{
                System.out.println(value);
            });
        });
    }

    public static void test1(){
        IntStream.rangeClosed(1, 10).forEach(value -> {
            threadPoolExecutor.submit(()->{
                System.err.println(value);
            });
        });
    }



}