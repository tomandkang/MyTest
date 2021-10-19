package com.example.demo.MyListener;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/5 16:58
 **/
public class Test1 {


    public static void main(String[] args) {
        ReadListener readListener = new ReadListener();
        ListenListener listenListener = new ListenListener();
        Student student = new Student();
        student.setReadListener(listenListener);
        // 当执行这个方法时，会自动调用ReadListener.isReading()方法
        student.read();

    }
}
