package com.example.demo.commom.myFilter;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = "/*",filterName = "myFilter") // 指定filter的处理路径和，filter名称
@Component
public class MyFilter {

}
