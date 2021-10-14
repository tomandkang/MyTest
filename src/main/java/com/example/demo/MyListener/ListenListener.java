package com.example.demo.MyListener;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/5 17:03
 **/
public class ListenListener implements Listener {
    @Override
    public void isReading(Event event) {
        /**
         * 使用 event.getStudent()方法获取事件源的引用，然后执行相关操作
         */

        System.out.println("正在听讲...");
    }
}
