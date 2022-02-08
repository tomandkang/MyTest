package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

import java.lang.reflect.Field;

public class ESUtil {


    @NotNull
    private IndexRequest getIndexRequest(String primary, String index, String type, Object o) throws Exception {
        String id = getFieldValueByFieldName(primary, o);
        String data = null;
        try {
            data = JSONObject.toJSONString(o);
        } catch (Exception e) {
            throw new Exception(e);
        }
        IndexRequest indexRequest = new IndexRequest(index, type, id);
        indexRequest.source(data, XContentType.JSON);
        return indexRequest;
    }

    public static String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //对private的属性的访问
            field.setAccessible(true);
            return field.get(object) == null ? null : field.get(object).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
