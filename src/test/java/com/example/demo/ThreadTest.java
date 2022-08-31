package com.example.demo;


import com.alibaba.fastjson.JSON;
import com.example.demo.commom.threads.MyThreadOne;
import com.example.demo.commom.threads.MyThreadThree;
import com.example.demo.commom.threads.MyThreadTwo;
import com.example.demo.entity.Father;
import com.example.demo.entity.Son;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ThreadTest extends DemoApplicationTests {

    private static final Random random = new Random();

    /**
     * 线程的五种状态: 新建 就绪 运行 阻塞 死亡
     * 线程进入阻塞的方法:
     * 1.
     */

    //@BeforeEach
    public void before() {

    }


    @Test
    public void test() {
        MyThreadOne myThreadOne = new MyThreadOne();
        Thread thread = new Thread(myThreadOne);
        thread.start();
    }

    @Test
    public void test1() {
        MyThreadTwo myThreadTwo = new MyThreadTwo(null);
        Thread thread = new Thread(myThreadTwo);
        thread.start();
    }

    @Test
    public void test2() throws Exception {
        MyThreadThree myThreadThree = new MyThreadThree();
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Object> submit = pool.submit(myThreadThree);
        System.out.println(submit.get());
    }

    @Test
    public void test3() throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        MyThreadTwo myThreadTwo = new MyThreadTwo(countDownLatch);
        Thread thread = new Thread(myThreadTwo);
        thread.start();

        countDownLatch.await();
        System.out.println("所有任务执行完");
    }

    @Test
    public void test4() throws Exception {
        Father son = new Son();
        son.say();
    }

    @Test
    public void test5() {
        List<String> sellPoints = new ArrayList<>();
        sellPoints.add("");
        sellPoints.add("123456789");
        sellPoints.add("qwer");
        sellPoints = sellPoints.stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(sellPoints));
    }

    @Test
    public void test6() {
        Map<String, String> map = new HashMap<>();
        map.put("haha", "haha");
        map.put("haha", "xixi");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    @Test
    public void test7() {
        while (true) {
            int i = random.nextInt(5);
            System.out.println(i);
        }
    }


}
