package com.example.demo.config;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/7/1 20:29
 **/
@Configuration
public class DataSourcesConfig {

    @Bean
    public DataSource getDataSource()throws Exception{
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(new File("classpath:application.yml"));
        return dataSource;
    }
}
