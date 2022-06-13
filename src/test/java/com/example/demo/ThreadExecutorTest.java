package com.example.demo;

import com.example.demo.commom.threads.ThreadPoolFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorTest extends DemoApplicationTests{

    private static final Integer WORKER_POOL_SIZE = 1;

    private ThreadPoolExecutor workerPool = new ThreadPoolExecutor(
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
        workerPool.awaitTermination(24, TimeUnit.HOURS);
    }

}
