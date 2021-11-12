package com.example.demo;

import com.example.demo.dao.IUserDAO;
import com.example.demo.entity.UserDTO;
import com.example.demo.service.IUserService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.UUID;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/14 16:00
 **/
public class MySelfTest extends DemoApplicationTests {

    @Autowired
    IUserDAO iUserDAO;

    @Autowired
    private IUserService iUserService;

    private JdbcTemplate jdbcTemplate;


    @Test
    public void test() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(6);
        userDTO.setOrderId(3);
        userDTO.setName("hehe");
        iUserDAO.batchInsert(Arrays.asList(userDTO));
    }

    @Test
    public void test_a_1(){
        long l = 1l;
        Boolean i=l!=1;
        System.out.println(i);
    }



    @Test
    public void test_1() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(5);
        userDTO.setOrderId(4);
        userDTO.setName("hehe");
        iUserService.batchInsert(Arrays.asList(userDTO));
        int i=1/0;
    }

    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    @Test
    public void test_2() {
        TransactionType txType0 = jdbcTemplate.execute("INSERT INTO t_name (name) VALUES (?)", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            //t_name表只有主键id和name两个字段
            preparedStatement.setString(1, UUID.randomUUID().toString().replaceAll("-", ""));
            preparedStatement.executeUpdate();
            return TransactionTypeHolder.get();
        });


        TransactionType txType1 = jdbcTemplate.execute("UPDATE test SET age = ? WHERE id = 1", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            //test表只有主键id和age两个字段
            preparedStatement.setInt(1, 18);
            preparedStatement.executeUpdate();
            return TransactionTypeHolder.get();
        });


        //抛出异常 事务回滚
        int a = 10 / 0;
    }


}
