package com.example.demo.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/7 11:15
 **/
@Data
public class AmazonTempInsertDTO {

    private Integer userId;
    private Integer orderId;
    private String shopAccount;
    private String siteCode;
    private String sku;
}
