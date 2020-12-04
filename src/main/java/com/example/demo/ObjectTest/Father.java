package com.example.demo.ObjectTest;


import com.example.demo.AnnotationTest.MyField;

public class Father {

    @MyField(FieldName="age",tableName = "age")
    private Integer age;
    @MyField(FieldName="name",tableName = "name")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
