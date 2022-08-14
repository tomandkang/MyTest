package com.example.demo;

import com.example.demo.commom.threads.ThreadPoolFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorTest extends DemoApplicationTests {

    private static final Integer WORKER_POOL_SIZE = 10;

    private ThreadPoolExecutor workPool = new ThreadPoolExecutor(
            WORKER_POOL_SIZE,
            WORKER_POOL_SIZE,
            0L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(2),
            new ThreadPoolFactory("ThreadExecutorTest"),
            new ThreadPoolExecutor.DiscardPolicy()
    );

    @Test
    public void test_0() throws Exception {
        //workPool.awaitTermination(24, TimeUnit.HOURS);
        for (int i = 0; i < 10; i++) {
            workPool.execute(() -> {
                System.out.println("名称:" + Thread.currentThread().getName());
            });
        }
        System.in.read();
    }

    @Test
    public void test_1() throws Exception {
        File file = new File("D:\\googleDownloads\\公司文件\\新建文本文档.txt");
        System.out.println(file.exists());
    }

    @Test
    public void test_2() throws Exception {
        Map<Long, String> soFarUpdateTimeMap = new HashMap<Long, String>();
        String s = soFarUpdateTimeMap.get(1L);
        System.out.println(s);

    }
}
