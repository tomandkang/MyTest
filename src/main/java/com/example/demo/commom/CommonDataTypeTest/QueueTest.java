package com.example.demo.commom.CommonDataTypeTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueTest {

    private static ThreadPoolExecutor pool=new ThreadPoolExecutor(1,1,0 ,TimeUnit.SECONDS ,new LinkedBlockingDeque<Runnable>(1),new DefaultThreadFactory("QueueTest"), new ThreadPoolExecutor.DiscardPolicy());
    private static int i=1;

    public static void main(String[] args) throws Exception {

        while (true){
            pool.submit(()->{
                 i++;
                System.out.println(Thread.currentThread().getName()+":"+i);
            });
            if(i>1000000000){
                break;
            }

        }
        System.out.println("结束");
    }
}
