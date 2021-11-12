package com.example.demo.service.impl;

import com.example.demo.dao.IUserDAO;
import com.example.demo.entity.UserDTO;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/11/12 11:45
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;
    @Override
    public void batchInsert(List<UserDTO> list) {
        userDAO.batchInsert(list);
    }
}
