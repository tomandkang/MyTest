package com.example.demo.commom.myHandler;

import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<MyBean>{

    @Override
    public MyBean getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

}
