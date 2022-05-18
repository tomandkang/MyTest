package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IOrderDao;
import com.example.demo.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChenTest extends DemoApplicationTests {


    @Autowired
    private IOrderDao iOrderDao;

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

        iOrderDao.insertOrder(order);
        iOrderDao.insertOrder(order1);
    }

    @Test
    public void test_1() throws Exception {
        List<Order> list = iOrderDao.getOrderList();
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test123(){
        String str="我是你媽0x1e/0x1c";
        String s = stripNonValidXMLCharacters(str);
        System.out.println(s);
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