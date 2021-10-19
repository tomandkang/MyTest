package com.example.demo.commom.config;

import com.example.demo.commom.myFilter.MyOwnFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/2/26 8:58
 **/

public class FilterConfig {


        @Autowired
        private MyOwnFilter myOwnFilter;


        public FilterRegistrationBean init(){
            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
            filterRegistrationBean.setFilter(myOwnFilter);
            filterRegistrationBean.setName("myOwnFilter");
            filterRegistrationBean.addUrlPatterns("/*");


            return filterRegistrationBean;
        }

}
