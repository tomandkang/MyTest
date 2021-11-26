package com.example.demo.RedisUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;

    @Bean
    public Jedis getJedis(){
        JedisPool jedisPool = new JedisPool(host, port);
        //从连接池中获得连接
        Jedis jedis = jedisPool.getResource();
        return  jedis;
    }
}
