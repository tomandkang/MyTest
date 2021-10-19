package com.example.demo.commom.testClass;

import lombok.Data;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/6/18 17:57
 **/
@Data
public class Test11 {

    String a;
    String b;
    String c;

    public static void main(String[] args) {
        String type="delete";
        String status="paused";

        //删除
        if("delete".equals(type)&&!"paused".equals(status)){

        }
    }
}
