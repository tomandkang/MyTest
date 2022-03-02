package com.example.demo.dao;


import com.example.demo.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 产品ID库 DAO
 * @author: gaoliangyou
 * @version: 2019/07/18 14:55
 */
@Mapper
public interface IUserDAO {


    void batchInsert(@Param("list") List<UserDTO> list);


    void insertUserDTO(UserDTO userDTO);
}
