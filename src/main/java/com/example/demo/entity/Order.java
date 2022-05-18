package com.example.demo.entity;

import lombok.Data;

import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

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
