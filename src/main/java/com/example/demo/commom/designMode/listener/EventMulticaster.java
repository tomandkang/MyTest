package com.example.demo.commom.designMode.listener;

/**
 * @description: 事件广播
 * @author: stone
 * @date: Created by 2021/4/8 10:36
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event.pattern
 *
    **事件广播器：
    **1.负责事件监听器的管理（注册监听器&移除监听器，将事件和监听器关联起来）
    **2.负责事件的广播（将事件广播给所有的监听器，对该事件感兴趣的监听器会处理该事件）
    **/
public interface EventMulticaster {

    /**
     * 广播事件所有的监听器，对该事件感兴趣的监听会处理该事件
     *
     * @param event
     */
    public void multicastEvent(AbstractEvent event);


    /**
     * 添加一个事件监听器
     *
     * @param eventListener
     */
    public void addEventListener(EventListener<?> eventListener);

    /**
     * 将一个监听器移除
     *
     * @param eventListener
     */
    public void removeEventListener(EventListener<?> eventListener);
}