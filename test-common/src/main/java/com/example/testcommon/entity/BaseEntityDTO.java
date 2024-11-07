package com.example.testcommon.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntityDTO implements Serializable {

    @JSONField(serialize = false)
    private Integer currentPage = 1;
    @JSONField(serialize = false)
    private Integer pageRows = 15;

    private Long operateUserId;

    private String operateUserName;

    private String menuId;

    @JSONField(serialize = false)
    private Boolean export = Boolean.valueOf(false);
    @JSONField(serialize = false)
    private Integer startIndex;

    private Date operateTime = new Date();


}
