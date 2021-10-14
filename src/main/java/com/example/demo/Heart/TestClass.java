package com.example.demo.Heart;

import io.netty.bootstrap.Bootstrap;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/5 16:00
 **/
public class TestClass {

    public static void main(String[] args) {
        ClientStarter starter = new ClientStarter(new Bootstrap());
        starter.connect();
    }
}
