package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/2 21:11
 **/
@Data
public class Order {

    private Integer id;

    private Integer orderNo;

    private Date orderTime;

    private String creater;

    private String orderContent;

}
