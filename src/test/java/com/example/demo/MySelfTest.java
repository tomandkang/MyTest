package com.example.demo;

import com.example.demo.dao.IUserDAO;
import com.example.demo.entity.UserDTO;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/14 16:00
 **/
public class MySelfTest extends DemoApplicationTests {

    @Resource
    IUserDAO iUserDAO;


    @Test
    public void test() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setOrderId(3);
        userDTO.setName("hehe");
        iUserDAO.batchInsert( Arrays.asList(userDTO));
    }

    @Test
    public void test_a_1(){
        long l = 1l;
        Boolean i=l!=1;
        System.out.println(i);
    }

}
