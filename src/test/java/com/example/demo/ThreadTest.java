package com.example.demo;


import com.example.demo.commom.threads.MyThreadOne;
import com.example.demo.commom.threads.MyThreadThree;
import com.example.demo.commom.threads.MyThreadTwo;
import com.example.demo.entity.Father;
import com.example.demo.entity.Son;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest extends DemoApplicationTests {


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
}
