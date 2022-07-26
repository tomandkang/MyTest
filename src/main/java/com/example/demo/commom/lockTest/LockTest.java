package com.example.demo.commom.lockTest;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args){
        BigDecimal a = new BigDecimal("1.01");
        BigDecimal b = new BigDecimal("1.0100");
        if(a.compareTo(b) == 0) {
            System.out.println("a等于b");
        }
    }


    public static void test() throws ArithmeticException{
        try {
            int i= 1/0;
        } catch (ArithmeticException e){
            throw new ArithmeticException();
        } catch (Exception e) {
        }
        System.out.println("hahaha");

    }
}
