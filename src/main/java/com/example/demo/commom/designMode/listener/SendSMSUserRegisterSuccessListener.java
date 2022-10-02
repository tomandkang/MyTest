package com.example.demo.commom.designMode.listener;

public class SendSMSUserRegisterSuccessListener implements EventListener<RegisterSuccessEvent> {

    @Override
    public void onEvent(RegisterSuccessEvent event) {
        System.out.println(event.getUsername() + "注册成功，发送短信。。。。。");

    }
}