package com.example.testapi.dto;

import lombok.Data;


import java.util.Date;

/**
 * 融电小程序用户表DTO实体类
 *
 * @author chenkangwen
 * @version v9.13.5
 * @date 2024-09-29 18:13:39
 */
@Data
public class MpUserDTO extends BaseEntityDTO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 伙伴人用户id
     */
    private Long userId;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 会话密钥
     */
    private String sessionKey;

    /**
     * 用户唯一标识OpenID
     */
    private String openId;


    /**
     * 删除标记:0-正常, 1-删除
     */
    private Byte delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


    /**
     * 微信小程序获取当前用户电话号码code
     */
    private String code;

    /**
     * 微信小程序登录jsCode
     */
    private String jsCode;

    /**
     * 验证码
     */
    private String verificationCode;

}
