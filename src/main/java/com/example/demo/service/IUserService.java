package com.example.demo.service;

import com.example.demo.entity.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@ShardingTransactionType(TransactionType.XA)
public interface IUserService {


    void batchInsert(List<UserDTO> list);
}
