package com.example.testservice;

import com.example.testapi.dto.BaseEntityDTO;
import com.example.testapi.dto.UserDTO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: chenkangwen
 * @CreateTime: 2023-08-10  10:29
 * @Description:
 * @Version: 1.0
 */
@SpringBootTest
public class CommonTest {

    private static Integer i = 1;

    private static final UserDTO userDTO = new UserDTO();

    public static Integer reverse(int num) {
        return ~(num - 1);
    }

    public static void main(String[] args) {
        if (Objects.nonNull(args)) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }
    }

    @Test
    public void test() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2024-08-29 19:34:41");
        Date parse1 = sdf.parse("2024-07-29 19:34:41");
        Date parse2 = sdf.parse("2024-06-29 19:34:41");
    }

    @Test
    public void test_1() {
        List<? extends BaseEntityDTO> list= new ArrayList<>();
        List<? super BaseEntityDTO> baseEntityDTOS= new ArrayList<>();
    }
}