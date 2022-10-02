package com.example.demo.commom.designMode.observer;

import java.util.ArrayList;
import java.util.List;

public class BusinessServer implements Observerable {
    private List<Observer> list; //面向接口编程
    private String msg;

    public BusinessServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!list.isEmpty()) {
            list.remove(observer);
        }
    }

    //遍历
    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(msg);//通知Observer调用update方法
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
        System.out.println("业务数据发生更新： " + msg);
        // 当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
        notifyObserver();  //消息更新，通知所有观察者
    }

}
