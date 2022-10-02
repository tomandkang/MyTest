package com.example.demo.commom.designMode.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration("eventConfig1")
public class EventConfig {

    /**
     * 注册一个事件发布者bean
     * @param eventListeners
     * @return
     */
    @Bean
    @Autowired(required = false)
    public EventMulticaster eventMulticaster(List<EventListener> eventListeners) {
        SimpleEventMulticaster simpleEventMulticaster = new SimpleEventMulticaster();
        if (eventListeners != null) {
            eventListeners.parallelStream().forEach(simpleEventMulticaster::addEventListener);
        }
        return simpleEventMulticaster;
    }

    /**
     * 用户注册服务
     * @param eventMulticaster
     * @return
     */
    @Bean
    public RegisterService registerService(EventMulticaster eventMulticaster) {
        RegisterService registerService = new RegisterService();
        registerService.setEventMulticaster(eventMulticaster);
        return registerService;
    }

    @Bean
    public EventListener<RegisterSuccessEvent> successEventEventListener() {
        return new SendSMSUserRegisterSuccessListener();
    }

    @Bean
    public EventListener<RegisterSuccessEvent> eventEventListener() {
        return new GetCouponRegisterSuccessListener();
    }
}
