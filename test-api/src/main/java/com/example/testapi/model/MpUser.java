package com.example.testapi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 融电小程序用户表DO实体类,与数据表相对应
 * @author chenkangwen
 * @date 2024-09-29 18:13:39
 * @version v9.13.5
 */
@Data
public class MpUser implements Serializable {


    /**主键*/
    private Long id;

    /**伙伴人用户id*/
    private Long userId;

    /**电话号码*/
    private String phone;

    /**会话密钥*/
    private String sessionKey;

    /**用户唯一标识OpenID*/
    private String openId;

    /**
     * 删除标记:0-正常, 1-删除
     */
    private Byte delFlag;

    /**创建时间*/
    private Date createTime;

    /**修改时间*/
    private Date updateTime;

}
