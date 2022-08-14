package com.example.demo.commom.config;

import com.example.demo.entity.TestA;
import com.example.demo.entity.TestB;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TestA.class,TestB.class,SelfImportSelector.class, SelfImportBeanDefinitionRegistrar.class})
public class ImportConfig {


}
