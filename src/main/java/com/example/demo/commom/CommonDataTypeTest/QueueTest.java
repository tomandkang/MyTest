package com.example.demo.commom.CommonDataTypeTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueTest {

    private static ThreadPoolExecutor pool=new ThreadPoolExecutor(3,5,0 ,TimeUnit.SECONDS ,new LinkedBlockingDeque<Runnable>(100));

    public static void main(String[] args) throws Exception {

            pool.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });

    }
}
