package com.example.demo.service.impl;

import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {
    private String need;


    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
}
