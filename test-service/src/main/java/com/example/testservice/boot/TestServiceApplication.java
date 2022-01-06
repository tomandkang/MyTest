package com.example.testservice.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestServiceApplication {

    private static Logger logger = LoggerFactory.getLogger(TestServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
        logger.info("-----------partner service.test start -----------------");
    }

}
