package com.example.demo.commom.threads;

import java.util.concurrent.Callable;

public class MyThreadThree implements Callable<Object> {


    @Override
    public Object call() throws Exception {

        return "hahaha";
    }
}
