package com.example.demo.commom.designMode.observer;

public interface Observerable {
    //添加观察者
    void registerObserver(Observer o);
    //删除观察者
    void removeObserver(Observer o);
    //通知观察者
    void notifyObserver();
}
