package com.example.demo.commom.designMode.listener;

/**
 * @description: 事件监听
 *
 * ：监听到事件发生的时候，做一些处理，比如上面的：路人A、路人B
 * @author: stone
 * @date: Created by 2021/4/8 10:29
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event.pattern
 */
public interface EventListener<E extends AbstractEvent> {

    /**
     * 此方法负责处理事件
     * @param e 事件对象
     */
    public void onEvent(E e);
}