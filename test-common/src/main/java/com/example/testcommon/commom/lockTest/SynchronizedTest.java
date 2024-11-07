package com.example.testcommon.commom.lockTest;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedTest implements Runnable {


    private AtomicInteger ai = new AtomicInteger(0);

    private static volatile Integer ir = 0;

    private static volatile Integer num=0;

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
        System.out.println(num);
    }




    public static void test() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    ir=ir+1;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(ir);
    }
}
