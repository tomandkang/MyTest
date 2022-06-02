package com.example.demo.commom.threads;

import java.util.concurrent.CountDownLatch;

public class MyThreadTwo implements Runnable {

    private CountDownLatch countDownLatch;

    private Integer num;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }



    public MyThreadTwo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public MyThreadTwo(CountDownLatch countDownLatch, Integer num) {
        this.countDownLatch = countDownLatch;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            System.out.println("异步线程执行了");
            Thread.yield();
            System.out.println("线程"+Thread.currentThread().getName());
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
