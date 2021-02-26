package com.example.demo.config;

import com.example.demo.MyFilter.MyOwnFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/2/26 8:58
 **/
@Configuration
public class FilterConfig {


        @Autowired
        private MyOwnFilter myOwnFilter;

        @Bean
        public FilterRegistrationBean init(){
            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
            filterRegistrationBean.setFilter(myOwnFilter);
            filterRegistrationBean.setName("myOwnFilter");
            filterRegistrationBean.addUrlPatterns("/*");
            return filterRegistrationBean;
        }

}
