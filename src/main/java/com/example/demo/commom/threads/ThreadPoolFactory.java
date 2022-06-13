/*
  @(#)ThreadPoolUtils.java 版 权：有棵树集团
 * @author 125C01063111
 * @version 1.0 2018年8月17日
 * <p>
 * Copyright (C) 2000,2018 , TeamSun, Inc.
 */
package com.example.demo.commom.threads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Param: 
 * @Return: 
 * @Date: 2022/6/13
 * @Author: chenkangwen       
 * @Desc:
 */
public class ThreadPoolFactory implements ThreadFactory {

    private AtomicInteger threadNumber = new AtomicInteger(1);

    private String prefix;

    public ThreadPoolFactory(String prefix) {
        super();
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, prefix + threadNumber.getAndIncrement());
    }

}
