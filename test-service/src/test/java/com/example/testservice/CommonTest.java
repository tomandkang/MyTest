package com.example.testservice;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: chenkangwen
 * @CreateTime: 2023-08-10  10:29
 * @Description:
 * @Version: 1.0
 */
public class CommonTest extends TestServiceApplicationTests {

    private static Integer i = 1;

    public static Integer reverse(int num) {
        return ~(num - 1);
    }

    @Test
    public void test() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2024-08-29 19:34:41");
        Date parse1 = sdf.parse("2024-07-29 19:34:41");
        Date parse2 = sdf.parse("2024-06-29 19:34:41");
    }

}