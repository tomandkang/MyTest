package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IOrderMapper;
import com.example.demo.entity.Order;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChenTest extends DemoApplicationTests {


    @Autowired
    private IOrderMapper iOrderMapper;

    @Test
    public void test_0() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = sdf.parse("2019-01-10 19:32:58");

        Order order = new Order();
        order.setId(1);
        order.setOrderContent("chenkangwen");
        order.setOrderNo(1);
        order.setOrderTime(new Date());


        Order order1 = new Order();
        order1.setId(2);
        order1.setOrderContent("chen");
        order1.setOrderNo(2);
        order1.setOrderTime(parse);

        iOrderMapper.insertOrder(order);
        iOrderMapper.insertOrder(order1);
    }

    @Test
    public void test_1() throws Exception {
        List<Order> list = iOrderMapper.getOrderList();
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test123() {
        BigDecimal height = new BigDecimal("3.00");
        BigDecimal heightTotal = new BigDecimal("0.00");
        for (int i = 1; i <= 3; i++) {
            heightTotal = heightTotal.add(height.multiply(new BigDecimal(i)));
        }
        System.err.println(heightTotal);
    }

    @Test
    public void test234() {
        String productAmount = "USD 13.85 ll  23   oo     yy";
        String[] flipping = flipping(productAmount);
        for (String str : flipping) {
            System.out.println(str);
        }

    }

    public static String[] flipping(String str) {
        String[] split = str.split("\\s+");//分割一个或多个空格
        return split;
    }

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    public void test345() {
        String str = "2021年10月16日 下午08时41分56秒";
        LocalDate localDate = dealAppealByText(str);
        System.out.println(localDate);
    }

    private LocalDate dealAppealByText(String appealByText) {
        int yearInt = appealByText.indexOf("年");
        int monthInt = appealByText.indexOf("月");
        int dayInt = appealByText.indexOf("日");
        if (yearInt > 0 && monthInt > 0 && dayInt > 0) {
            String year = appealByText.substring(0, yearInt);
            String month = appealByText.substring(yearInt + 1, monthInt);
            String day = appealByText.substring(monthInt + 1, dayInt);
            String dateStr = year + "-" + month + "-" + day;
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        }
        return null;
    }


    @Test
    public void test346() {
        String str = "大奉打更人";
        String s = unicodeToString(str);
        System.out.println(s);
    }


    /**
     * @Param: [str]
     * @Return: java.lang.String
     * @Date: 2022/8/27
     * @Author: chenkangwen
     * @Desc: Unicode转汉字字符串
     */
    public String unicodeToString(String str) {
        if (!StringUtils.isEmpty(str)) {
            Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
            Matcher matcher = pattern.matcher(str);
            char ch;
            while (matcher.find()) {
                String group = matcher.group(2);
                ch = (char) Integer.parseInt(group, 16);
                String group1 = matcher.group(1);
                str = str.replace(group1, ch + "");
            }
        }
        return str;
    }

    // 保留合法字符
    public String stripNonValidXMLCharacters(String in) {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        char current; // Used to reference the current character.

        if (in == null || ("".equals(in))) return ""; // vacancy test.
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
            if ((current == 0x9) ||
                    (current == 0xA) ||
                    (current == 0xD) ||
                    ((current >= 0x20) && (current <= 0xD7FF)) ||
                    ((current >= 0xE000) && (current <= 0xFFFD)) ||
                    ((current >= 0x10000) && (current <= 0x10FFFF)))
                out.append(current);
        }
        return out.toString();
    }


    // 保留合法字符
    public String stripNonValidXMLCharacters1(String in) {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        char current; // Used to reference the current character.
        if (in == null || ("".equals(in))) return ""; // vacancy test.
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
            if ((current == 0x9) ||
                    (current == 0xA) ||
                    (current == 0xD) ||
                    ((current >= 0x20) && (current <= 0xD7FF)) ||
                    ((current >= 0xE000) && (current <= 0xFFFD)) ||
                    ((current >= 0x10000) && (current <= 0x10FFFF)))
                out.append(current);
        }
        return out.toString();
    }

}