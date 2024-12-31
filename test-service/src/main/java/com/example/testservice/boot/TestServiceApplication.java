package com.example.testservice.boot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example")
@ComponentScan(basePackages = "com.example")
@MapperScan(value = "com.example.testservice.dao", annotationClass = Mapper.class)
public class TestServiceApplication {

    private static Logger logger = LoggerFactory.getLogger(TestServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
        logger.info("-----------partner service.test start -----------------");
    }

}
