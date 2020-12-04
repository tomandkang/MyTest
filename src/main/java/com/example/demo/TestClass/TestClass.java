package com.example.demo.TestClass;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class TestClass {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 匹配只能包含xyzwf数字和加减乘除
     */
    public static final Pattern REG_FORMULA_PATTERN = Pattern.compile("^[+\\-\\*\\/\\=\\>\\<\\.xyzwf0-9]+$");

    public static void main(String[] args) throws Exception {


        String json="{\"data\":{\"sizeCondition\":[\"1+1=2\",\"2\"],\"weightCondition\":[\"x*y*z<=33*23*3\"],\"feeInfo\":[{\"site\":\"US\",\"fee\":\"1\"}],\"bigSiteCode\":2,\"sizeType\":1,\"platformPackageWeight\":1,\"maxWeight\":1},\"ticket\":\"f42e5edb33d7aaec68dd4358a9948d3d\",\"operator\":\"songxulin\",\"personName\":\"宋徐林\",\"funcVersion\":\"557a74e41f37da5c73a4193e7f008809\",\"moduleUrl\":\"/publish/salespricing/fbaFeeStting/\",\"requestId\":\"1202102215149940f90a416b83eea438\",\"deviceName\":\"Chrome浏览器\"}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject data = jsonObject.getJSONObject("data");
        String sizeCondition = data.getString("sizeCondition");
        List<String> strings = JSONArray.parseArray(sizeCondition, String.class);
        String s = validatorMathFormula(strings);
        System.out.println(s);
    }

    public static Date getZeroTime(int days){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    public static String validatorMathFormula(Collection<String> expressionCollection) {
        try {
            for (String expression : expressionCollection) {
                boolean matches = REG_FORMULA_PATTERN.matcher(expression).matches();
                if (!matches) {
                    return  "公式不符合规范，只能是包含x、y、z、w、w1、f变量的的数学表达式";
                }
                // 验证公式正确性
                Expression compiledExpression = AviatorEvaluator.compile(expression, true);
                if (compiledExpression == null) {
                    return  "公式不符合规范，解析失败！请检查公式";
                }
                String[] attr1 = expression.split(">");
                String[] attr2 = expression.split("<");
                String[] attr3 = expression.split("==");
                if (attr1.length > 2 || attr2.length > 2 || attr3.length > 2) {
                    return  "公式不符合规范，单个公式只能填写一个表达式，如果是范围类型可拆分为两个公式：如2<w<=20可写为w>2,w<=20";
                }
            }
        } catch (Exception e) {
            return  "公式不符合规范:" + e.getMessage();
        }
        return Boolean.TRUE.toString();
    }


}
