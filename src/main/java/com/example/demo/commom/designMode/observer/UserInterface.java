package com.example.demo.commom.designMode.observer;

public class UserInterface implements Observer {
    private String name;
    private String msg;
    
    public UserInterface(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        this.msg = message;
        System.out.println(name + " 收到推送消息： " + msg);
    }
    
}
