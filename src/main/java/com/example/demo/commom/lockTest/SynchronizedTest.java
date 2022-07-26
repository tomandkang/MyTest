package com.example.demo.commom.lockTest;


import java.util.concurrent.CountDownLatch;

public class SynchronizedTest implements Runnable {

    private volatile int num=0;

    private static CountDownLatch countDownLatch = new CountDownLatch(5);


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
        countDownLatch.countDown();
    }


    public static void main(String[] args) throws Exception{
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread t1 = new Thread(synchronizedTest);
        Thread t2 = new Thread(synchronizedTest);
        Thread t3 = new Thread(synchronizedTest);
        Thread t4 = new Thread(synchronizedTest);
        Thread t5 = new Thread(synchronizedTest);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        countDownLatch.await();
        System.out.println(synchronizedTest.num);
    }
}
