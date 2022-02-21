package com.example.demo.commom.ObjectTest;

public class BitOperationTest {

    public static void main(String[] args) {
       // test_1();
       // test_2();
        test_4();
       //int i = test_3(456);

    }

    //位移运算 int32位
    public static void test_1() {
        //0000 0000 0000 0000 0000 0000 0000 0001
        int i = 1;
        System.out.println(i << 3);
        System.out.println(i >> 3);
    }

    //无符号位移运算 int32位
    public static void test_2() {
        //负数计算机以补码表示
        //-15
        //15的二进制码
        //0000 0000 0000 0000 0000 0000 0000 1111
        //-15的二进制码
        //补码=反码+1
        // 反码:1111 1111 1111 1111 1111 1111 1111 0000
        // 补码:1111 1111 1111 1111 1111 1111 1111 0001
        int i = -15;
        System.out.println(i << 2);
        System.out.println(i >>> 2);
    }

    public static int test_3(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
           if ((newRes - t) / 10 != res) return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    public static void test_4() {
        //0000 0000 0000 0000 0000 0000 0000 0100  二进制码 4
        //1111 1111 1111 1111 1111 1111 1111 1011 新数的二进制码 负数补码
        //1111 1111 1111 1111 1111 1111 1111 1010 反码
        //0000 0000 0000 0000 0000 0000 0000 0101 二进制码 5

        //0000 0000 0000 0000 0000 0000 0000 1000 二进制码 8
        //1111 1111 1111 1111 1111 1111 1111 0111 新数的二进制码 负数补码
        //1111 1111 1111 1111 1111 1111 1111 0110 反码
        //0000 0000 0000 0000 0000 0000 0000 1001 二进制码 9

        //1111 1111 1111 1111 1111 1111 1111 0110


        int a=8;
        System.out.println(~a);
    }


}


