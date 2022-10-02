package com.example.demo.commom.designMode.listener;

import lombok.Data;

/**
 * @description: 用户注册服务
 * @author: stone
 * @date: Created by 2021/4/8 14:14
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event
 */
@Data
public class RegisterService {

    private EventMulticaster eventMulticaster;

    public void register(String username) {
        //用户注册，将数据写人到数据库中
        System.out.println("用户注册成功。。。。" + username);

        //事件广播
        //使用事件发布者eventPublisher发布用户注册成功的消息:
        this.eventMulticaster.multicastEvent(new RegisterSuccessEvent(this, username));
    }
}