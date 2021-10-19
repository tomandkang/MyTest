package com.example.demo.commom.myListener;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/5 16:57
 **/
public class ReadListener implements Listener{

    @Override
    public void isReading(Event event) {
        /**
         * 使用 event.getStudent()方法获取事件源的引用，然后执行相关操作
         */
        event.getStudent().read();
        System.out.println("正在读书...");
    }

}
