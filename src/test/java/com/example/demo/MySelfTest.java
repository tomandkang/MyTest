package com.example.demo;

import com.example.demo.dao.IPlsProductIdLibraryDAO;
import com.example.demo.entity.AmazonTempInsertDTO;
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
    IPlsProductIdLibraryDAO iPlsProductIdLibraryDAO;


    @Test
    public void test() {

        AmazonTempInsertDTO amazonTempInsertDTO = new AmazonTempInsertDTO();
        amazonTempInsertDTO.setUserId(1);
        amazonTempInsertDTO.setOrderId(12);
        amazonTempInsertDTO.setShopAccount("ckw");
        amazonTempInsertDTO.setSiteCode("ckw");
        amazonTempInsertDTO.setSku("ckw");

        AmazonTempInsertDTO amazonTempInsertDTO1 = new AmazonTempInsertDTO();
        amazonTempInsertDTO1.setUserId(2);
        amazonTempInsertDTO1.setOrderId(91);
        amazonTempInsertDTO1.setShopAccount("ckw");
        amazonTempInsertDTO1.setSiteCode("ckw");
        amazonTempInsertDTO1.setSku("ckw");

        iPlsProductIdLibraryDAO.batchInsertTempInsertDTO( Arrays.asList(amazonTempInsertDTO, amazonTempInsertDTO1));
    }

    @Test
    public void test_a_1(){
        long l = 1l;
        Boolean i=l!=1;
        System.out.println(i);
    }

}
