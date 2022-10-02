package com.example.demo.commom.designMode.listener;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 事件对象
 * @author: stone
 * @date: Created by 2021/4/8 10:21
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.spring.event.pattern
 */
@Data
@AllArgsConstructor
public abstract class AbstractEvent {

    //事件源

    //事件源：事件的触发者，比如上面的注册器就是事件源。
    private Object source;
}