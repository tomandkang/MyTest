package com.example.demo.commom.myFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class filterConfig {


    @Bean
    public FilterRegistrationBean<MyOwnFilter> myFilter(){
        final FilterRegistrationBean<MyOwnFilter> registrationBean = new FilterRegistrationBean<>();
        final MyOwnFilter myFilter = new MyOwnFilter();
        registrationBean.setFilter(myFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        registrationBean.setName("myFilter");
        return registrationBean;
    }
}
