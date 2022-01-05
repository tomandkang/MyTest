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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<UserDTO> userDTOS = new ArrayList<>();

        UserDTO userDTO = new UserDTO();
        userDTO.setRoleId(1);
        userDTO.setUserId(1);
        userDTO.setName("ABC");
        userDTOS.add(userDTO);

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setRoleId(2);
        userDTO1.setUserId(2);
        userDTO1.setName("康文");
        userDTOS.add(userDTO1);


        UserDTO userDTO2 = new UserDTO();
        userDTO2.setRoleId(3);
        userDTO2.setUserId(3);
        userDTO2.setName("mexi");
        userDTOS.add(userDTO2);


        UserDTO userDTO3 = new UserDTO();
        userDTO3.setRoleId(4);
        userDTO3.setUserId(4);
        userDTO3.setName("hehe");
        userDTOS.add(userDTO3);

        iUserDAO.batchInsert(userDTOS);



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
        userDTO.setRoleId(4);
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
