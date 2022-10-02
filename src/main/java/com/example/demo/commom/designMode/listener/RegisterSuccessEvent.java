package com.example.demo.commom.designMode.listener;

import lombok.Getter;

/**
 * @description: 用户注册事件
 * @author: stone
 * @date: Created by 2021/4/8 11:56
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event
 */
@Getter
public class RegisterSuccessEvent  extends AbstractEvent {

    private String username;

    public RegisterSuccessEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
}