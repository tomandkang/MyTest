package com.example.demo.commom.designMode.listener;

/**
 * @description: 注册成功后发优惠券
 * @author: stone
 * @date: Created by 2021/4/8 15:28
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event
 */
public class GetCouponRegisterSuccessListener implements EventListener<RegisterSuccessEvent> {

    @Override
    public void onEvent(RegisterSuccessEvent event) {
        System.out.println(event.getUsername() + "注册成功，赠送优惠券。。。。。");

    }
}