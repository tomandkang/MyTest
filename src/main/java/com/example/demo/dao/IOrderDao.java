package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface IOrderDao {

    Order getOrderById(@Param("orderId") String orderId);
}
