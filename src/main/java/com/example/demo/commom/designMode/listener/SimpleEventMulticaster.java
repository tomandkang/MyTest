package com.example.demo.commom.designMode.listener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 简单事件广播
 * @author: stone
 * @date: Created by 2021/4/8 11:04
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event
 */
public class SimpleEventMulticaster implements EventMulticaster {

    private Map<Class<?>, List<EventListener>> eventObjectEventListenerMap = new ConcurrentHashMap<>();


    @Override
    public void multicastEvent(AbstractEvent event) {
        List<EventListener> eventListeners = eventObjectEventListenerMap.get(event.getClass());
        if (eventListeners != null) {
            eventListeners.parallelStream().forEach(e -> e.onEvent(event));
        }

    }

    @Override
    public void addEventListener(EventListener<?> eventListener) {
        Class<?> eventType = this.getEventType(eventListener);
        List<EventListener> listeners = this.eventObjectEventListenerMap.computeIfAbsent(eventType, e -> new ArrayList<>());
        listeners.add(eventListener);
    }

    @Override
    public void removeEventListener(EventListener<?> eventListener) {
        Class<?> eventType = this.getEventType(eventListener);
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(eventListener);
        }
    }

    /**
     * 获取事件的类型,这里的代码可能不是很常见，其实就是获取泛型类型而已
     * @param eventListener
     * @return
     */
    protected Class<?> getEventType(EventListener<? extends AbstractEvent> eventListener) {
        ParameterizedType parameterizedType = (ParameterizedType) eventListener.getClass().getGenericInterfaces()[0];
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
        return (Class<?>) actualTypeArgument;
    }
}