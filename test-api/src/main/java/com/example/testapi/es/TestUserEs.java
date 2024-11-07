package com.example.testapi.es;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;


@Data
@Document(indexName = "#{ T(com.example.testapi.es.TestUserEs).getEsName() }", shards = 3, replicas = 1, refreshInterval = "5s")
public class TestUserEs implements Serializable {


    public static String getEsName() {
        return "test_user";
    }

    private Long id;

    private Integer age;

    private Date birthday;

    private String name;

    private String remake;
}
