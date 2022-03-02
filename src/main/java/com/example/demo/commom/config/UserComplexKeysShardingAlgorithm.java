package com.example.demo.commom.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Integer> {


    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_ROLE_ID = "role_id";



    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Integer> shardingValue) {

        if (shardingValue.getColumnNameAndShardingValuesMap().isEmpty()) {
            throw new RuntimeException("不支持除了=和in的操作");
        }


        Collection<Integer>  userIds = shardingValue.getColumnNameAndShardingValuesMap().getOrDefault(COLUMN_USER_ID, new ArrayList<>(1));
        Collection<Integer>  roleIds = shardingValue.getColumnNameAndShardingValuesMap().getOrDefault(COLUMN_ROLE_ID, new ArrayList<>(1));

        List<String> ids = new ArrayList<>(16);
        ids.addAll(ids2String(userIds));
        ids.addAll(ids2String(roleIds));


        List<String> collect = ids.stream()
                // 截取后2位
                .map(id -> id.substring(id.length() - 2))
                // 去重
                .distinct()
                // 转换成int
                .map(Integer::new)
                // 对可用的表名求余数，获取到真实的表的后缀
                .map(idSuffix -> idSuffix % availableTargetNames.size())
                // 转换成string
                .map(String::valueOf)
                // 获取到真实的表
                .map(tableSuffix -> availableTargetNames.stream().filter(targetName -> targetName.endsWith(tableSuffix)).findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return collect;
    }

    /**
     * 转换成String
     */
    private List<String> ids2String(Collection<?> ids) {
        List<String> result = new ArrayList<>(ids.size());
        ids.forEach(id -> result.add(Objects.toString(id)));
        return result;
    }
}
