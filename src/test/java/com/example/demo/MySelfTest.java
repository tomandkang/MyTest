package com.example.demo;

import com.example.demo.dao.IUserDAO;
import com.example.demo.entity.UserDTO;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/14 16:00
 **/
public class MySelfTest extends DemoApplicationTests {

    @Resource
    IUserDAO iUserDAO;

    //id主键一般是由雪花算法生成，可自定义（redis自增长）
    @Test
    public void test() {
        List<UserDTO> userDTOS = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setRoleId(1);
        userDTO.setUserId(1);
        userDTO.setName("康文");
        userDTOS.add(userDTO);

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setRoleId(2);
        userDTO1.setUserId(2);
        userDTO1.setName("康帅");
        userDTOS.add(userDTO1);

        iUserDAO.batchInsert(userDTOS);
    }



    @Test
    public void test_1() {

        UserDTO userDTO = new UserDTO();
        userDTO.setRoleId(312);
        userDTO.setUserId(312);
        userDTO.setName("康文");
        iUserDAO.insertUserDTO(userDTO);
    }


    @Test
    public void test_a_1(){
        long l = 1l;
        Boolean i=l!=1;
        System.out.println(i);
    }

}
