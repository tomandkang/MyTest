package com.example.demo.commom.ObjectTest;


import com.example.demo.commom.testClass.AccountGroup;
import com.example.demo.commom.testClass.DateValidator;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;


public class Father {



    @NotEmpty(message ="父亲名字不能为空", groups = {AccountGroup.class})
    private String name;

    @Range(max =100,message ="年龄最大为100岁")
    private Integer age;

    @DateValidator(dateFormat = "yyyy-MM-dd", groups = {AccountGroup.class})
    private String date;


    public Father() {
    }

    public Father(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
