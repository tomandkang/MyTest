package com.example.testapi.dto;

import lombok.Data;

/**
 * @Author: chenkangwen
 * @CreateTime: 2024-10-18  09:53
 * @Description:
 * @Version: 1.0
 */
@Data
public class UserDTO extends BaseEntityDTO {

    private Long id;

    private String userCode;

    private String userName;

    private Byte sex;

    private String phone;

    private Integer delFlag;



}
