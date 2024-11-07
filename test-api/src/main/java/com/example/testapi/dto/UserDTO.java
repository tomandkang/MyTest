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

    private Integer age;

    private String phone;

    private Integer delFlag;

    public UserDTO() {

    }

    public UserDTO(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
}
