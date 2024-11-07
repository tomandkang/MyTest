package com.example.testservice.commom.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;


@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Autowired
    ElasticsearchRestClientProperties elasticsearchRestClientProperties;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticsearchRestClientProperties.getUris().toArray(new String[elasticsearchRestClientProperties.getUris().size()]))
                .withBasicAuth(elasticsearchRestClientProperties.getUsername(), elasticsearchRestClientProperties.getPassword())
                .withConnectTimeout(elasticsearchRestClientProperties.getConnectionTimeout())
                .withSocketTimeout(elasticsearchRestClientProperties.getReadTimeout())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Override
    @Bean(name = { "elasticsearchOperations", "elasticsearchTemplate", "elasticsearchRestTemplate" })
    public ElasticsearchRestTemplate elasticsearchOperations(ElasticsearchConverter elasticsearchConverter) {
        return new ElasticsearchRestTemplate(elasticsearchClient(), elasticsearchConverter);
    }
}
