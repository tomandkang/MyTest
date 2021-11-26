package com.example.demo.CommonDataTypeTest;

public class ThreadTest extends Thread{


    public static void main(String[] args) {

        ThreadTest t = null;
        try {
            t = new ThreadTest();
            t.start();
            t.suspend();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        super.run();
        for(int i=0;i<1000000000;i++){
            System.out.println(i);
        }

    }
}
