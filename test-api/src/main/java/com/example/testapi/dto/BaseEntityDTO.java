package com.example.testapi.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class BaseEntityDTO implements Serializable {


    private Integer currentPage;


    private Integer pageRows;


    private Long operateUserId;


    private String operateUserName;


    private String menuId;


    private Boolean export;


    private Integer startIndex;


    private Date operateTime;

}
