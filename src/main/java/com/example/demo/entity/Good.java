package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Good {
   private Integer id;
   private String  goodName;
   private String creater;
   private Date createDate;
}
