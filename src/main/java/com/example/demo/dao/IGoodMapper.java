package com.example.demo.dao;

import com.example.demo.entity.Good;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGoodMapper {


   void insertGood(Good good);


    Good getGoodById(Integer id);
}
