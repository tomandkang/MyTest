package com.example.demo.commom.SortTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HeapSort {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
        List<String> sellerAccounts = (List<String>) null;
        System.out.println(sellerAccounts);
    }


    public static void heap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {

            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static Date getZeroTime(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static void arrayTest() {

        //一维数组初始化
        int[] a = {1, 2, 3};
        int[] b = new int[10];
        int[] c = new int[]{1, 2, 3, 4};


        //二维数组初始化
        //m*n
        //m表示这个二维数组有多少个数组
        //n表示一维数组元素个数
        //一维数组的元素个数，可以动态的给出
        int[][] d = new int[10][];
        d[0] = new int[10];
        d[1] = new int[8];
        d[2] = new int[7];

        int[][] e = new int[10][10];
        int[][] f = {{1, 2, 3}, {4, 6}, {6}};
        int[][] g = new int[][]{{1, 2, 3, 4, 5}, {4, 6, 7}, {6}};
    }

    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = res;
            res = new StringBuilder();
            count = 1;
            //遇到新的字符
            say = prev.charAt(0);
            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    //如果遇到了新的字符，把它的数量和字符都加入到res中，
                    //然后count置为1，再把say赋予遇到的新的字符
                    res.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    //如果不是新的字符，计算当前字符的数量
                    count++;
                }
            }
            res.append(count).append(say);
        }
        return res.toString();
    }



}
