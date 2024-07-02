package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: chenkangwen
 * @CreateTime: 2023-08-10  10:29
 * @Description:
 * @Version: 1.0
 */
public class CommonTest extends DemoApplicationTests {

    private static Integer i = 1;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public Integer reverse(int num) {
        return ~(num - 1);
    }


    public static void main(String[] args) {
        // 1的补码为:0000 0000 0000 0000 0000 0000 0000 0001
        //-1的原码为:1000 0000 0000 0000 0000 0000 0000 0001
        //-1的反码为:1111 1111 1111 1111 1111 1111 1111 1110
        //-1的补码为:1111 1111 1111 1111 1111 1111 1111 1111
        System.out.println(Math.pow(2, 0));
        //4的二进制0000 0100
        System.out.println(Math.pow(2, 2));
        //8的二进制0000 1000
        System.out.println(Math.pow(2, 3));
        //16的二进制0001 0000
        System.out.println(Math.pow(2, 4));

        int number = -1;
        String binaryString = Integer.toBinaryString(number);
        System.out.println(binaryString);

    }


    @Test
    public void test41() {

        String str = "hello";
        int hash = this.hash(str);
        System.out.println(hash);
    }

    public int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    @Test
    public void test1() {
        String join = StringUtils.join(1, 2);
        System.out.println(join);
    }


    @Test
    public void test2() throws Exception {

        String sql = "SELECT t.id AS 'value',t.real_name AS 'label' FROM t_user t WHERE t.del_flag = 0 AND t.master` = 1 AND t.position = 0 AND t.role_id = 1707111506105509282 AND t.office_id = '1908140940507574151'";
        /**
         * 校验sql关键字
         */
        String REG = "(?<!`)master(?!`)|truncate|insert|delete|update|declare|alert|drop";
        /**
         * 表示忽略大小写
         */
        Pattern SQL_PATTERN = Pattern.compile(REG, Pattern.CASE_INSENSITIVE);

        Matcher matcher = SQL_PATTERN.matcher(sql);

        boolean b = matcher.find();

        System.out.println(b);
    }


    public void stopWatchTest() throws Exception {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("task1");
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println("task1耗时毫秒：" + stopWatch.getLastTaskTimeMillis());

        stopWatch.start("task2");
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        Thread.sleep(2000);
        stopWatch.stop();
        System.out.println("task2耗时毫秒：" + stopWatch.getLastTaskTimeMillis());

        System.out.println("总任务数：" + stopWatch.getTaskCount());
        System.out.println("总耗时毫秒：" + stopWatch.getTotalTimeMillis());
        System.out.println("所有任务简要信息：\n" + stopWatch.shortSummary());
        System.out.println("所有任务详细信息：\n" + stopWatch.prettyPrint());
    }


    @Test
    public void test3() {
        String str = "master SELECT t.id AS 'value',t.real_name AS 'label' FROM t_user t WHERE t.del_flag=0 AND t.`master`=1 AND t.`master`=1 AND t.role_id=1607081635265834181 AND t.office_id= ?";
        //非法字符
        String[] keywords = {"master", "truncate", "insert", "delete", "update", "declare", "alert", "drop"};
        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                int i = str.split(keyword).length - 1;
                int j = str.split(StringUtils.join("`", keyword, "`")).length - 1;

                throw new RuntimeException("包含非法字符");
            }
        }
    }

    @Test
    public void test4() {
        int i = BigDecimal.ZERO.compareTo(new BigDecimal("0"));
        System.out.println(i);
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        System.out.println(JSON.toJSONString(list));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("xixi");
        linkedList.add("xixi");
        System.out.println(JSON.toJSONString(linkedList));

        Stack<String> stack = new Stack<>();
        stack.add("哈哈哈");
        stack.add("哈哈哈");
        System.out.println(JSON.toJSONString(stack));

        Vector vector = new Vector();

    }


    @Test
    public void testMap() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "hello");
        map.put("hello", "hello");
        System.out.println(JSON.toJSONString(map));

        Hashtable<String, String> table = new Hashtable<>();
        table.put("hello", "hello");
        table.put("hello", "hello");
        System.out.println(JSON.toJSONString(table));

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("hello", "hello");
        treeMap.put("hello", "hello");
        System.out.println(JSON.toJSONString(treeMap));

    }

    @Test
    public void test7() {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        Integer YEAR = calendar.get(Calendar.YEAR);

        Integer MONTH = calendar.get(Calendar.MONTH);

        Integer WEEK_OF_YEAR = calendar.get(Calendar.WEEK_OF_YEAR);

        Integer WEEK_OF_MONTH = calendar.get(Calendar.WEEK_OF_MONTH);

        Integer DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);

        Integer DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);

        Integer DATE = calendar.get(Calendar.DATE);

        System.out.println(String.format("年:%s,月:%s,日:%s,当年第几周:%s,当月第几周:%s,当月第几天:%s,当年第几天:%s;", YEAR, MONTH, DATE, WEEK_OF_YEAR, WEEK_OF_MONTH, DAY_OF_MONTH, DAY_OF_YEAR));
    }

    @Test
    public void test8() {
        String parentIds = "0,9c96cc062560438998ed5022993e4184,4a4a0f5ce808468fa250c28876ae3e3a,1812312025389291129,1901071420103401799,2210241012481197392,";
        List<String> list = Arrays.asList(parentIds.split(","));
        System.out.println(JSON.toJSONString(list));

        BigDecimal a = new BigDecimal("5.00");
        BigDecimal b = new BigDecimal("3.00");
        BigDecimal result = a.divide(b, 2, RoundingMode.HALF_UP);
        System.out.println(result);


    }

    @Test
    public void test() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }


    public String encrypt(String password) {
        // 1.生成随机盐值
        // 通过UUID生成唯一的数字作为随机盐值
        String salt = UUID.randomUUID().toString().replace("-", "");// 顺便去掉 -
        // 2.根据初始密码 和 随机盐值 通过md5生成 加盐加密的密码
        // StandardCharsets.UTF_8  设置编码格式
        String finalPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes(StandardCharsets.UTF_8));
        // 3.将盐值 和 加盐加密得到的密码一起返回(合并盐值和加盐密码)
        return salt + "$" + finalPassword;
    }

    @Test
    public void test9() {
        String str = "456789";
        String str1 = new String("456789");
        System.out.println(str == str1);
    }


    @Test
    public void test11() throws Exception {
        Date startTime = simpleDateFormat.parse("2023-01-05 11:35:55");
        Date endTime = simpleDateFormat.parse("2023-06-24 11:35:55");
        // 周期结束时间
        Calendar maxCalendar = Calendar.getInstance();
        maxCalendar.setTime(endTime);
        this.getEndingOfCalendar(maxCalendar);
        // 开始时间
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);
        this.getStartOfCalendar(startCalendar);
        // 结束时间
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(startTime);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        this.getEndingOfCalendar(endCalendar);


        recursion(startCalendar, endCalendar, maxCalendar);
    }


    public void recursion(Calendar startCalendar, Calendar endCalendar, Calendar maxCalendar) {
        //如果是同一个月
        if (startCalendar.get(Calendar.YEAR) == maxCalendar.get(Calendar.YEAR) && startCalendar.get(Calendar.MONTH) == maxCalendar.get(Calendar.MONTH)) {
            endCalendar = maxCalendar;
            //处理数据
            handler(startCalendar, endCalendar);
            return;
        }
        //处理数据
        handler(startCalendar, endCalendar);
        // 开始时间
        startCalendar.add(Calendar.MONTH, 1);
        startCalendar.set(Calendar.DAY_OF_MONTH, startCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        // 结束时间
        endCalendar.add(Calendar.MONTH, 1);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        recursion(startCalendar, endCalendar, maxCalendar);
    }


    public void handler(Calendar startCalendar, Calendar endCalendar) {
        String start = simpleDateFormat.format(startCalendar.getTime());
        String end = simpleDateFormat.format(endCalendar.getTime());
        int days = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH) + 1;
        int monthDays = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) - startCalendar.getActualMinimum(Calendar.DAY_OF_MONTH) + 1;
        System.out.println(String.format("开始时间：%s;结束时间：%s,周期天数：%s,该月总天数：%s;%s", start, end, days, monthDays, "\n"));
    }


    /**
     * @description: 获取一天结束时间
     * @author: chenkangwen
     * @date: 2024/6/24
     * @param: [calendar]
     */
    public Calendar getEndingOfCalendar(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar;
    }


    /**
     * @description: 获取一天开始
     * @author: chenkangwen
     * @date: 2024/6/24
     * @param: [calendar]
     */
    public Calendar getStartOfCalendar(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar;
    }

}