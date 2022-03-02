package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Integer id;

    private Integer orderNo;

    private Date orderTime;

    private String creater;

    private String orderContent;
}
