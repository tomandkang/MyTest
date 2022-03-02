package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface IOrderDao {

    Order getOrderById(@Param("id") Integer id);


    int insertOrder(Order order);


    List<Order> getOrderList();
}
