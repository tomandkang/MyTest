package com.example.demo.commom.shardingConfig;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/11/12 9:46
 **/
public class MyPreciseDBShardingAlgorithm implements PreciseShardingAlgorithm<Long> {


    /**
     * 数据分片
     *
     * @param dbNames              实际数据源集合; springboot0、springboot1
     * @param preciseShardingValue 分片键 name 用户名值
     * @return
     */
    @Override
    public String doSharding(Collection<String> dbNames, PreciseShardingValue<Long> preciseShardingValue) {

        for (String each : dbNames) {
            // 将余数与配置的实际数据库名进行匹配
            if (each.endsWith(preciseShardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
