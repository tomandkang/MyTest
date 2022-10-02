package com.example.demo.commom.designMode.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        //模拟用户注册
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        RegisterService bean = context.getBean(RegisterService.class);
        //用户注册
        bean.register("administrator");
    }
}
