package com.example.demo.commom.myHandler.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/14 11:53
 * @description
 */
@Data
public class BaseEmail implements Serializable {
    private static final long serialVersionUID = 7356135633389661276L;
    /**
     * 邮箱
     */
    private String username;

    /**
     * 授权码
     */
    private String password;

    /**
     * 获取邮箱列表开始时间
     */
    private Date startTime;

    /**
     * 获取邮箱列表结束时间
     */
    private Date endTime;

    public BaseEmail(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BaseEmail(String username, String password, Date startTime, Date endTime) {
        this.username = username;
        this.password = password;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
