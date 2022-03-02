package com.example.demo.dao;

import com.example.demo.entity.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGoodDao {


   void insertGood(Good good);


    Good getGoodById(Integer id);


    List<Good> getGoodList();
}
