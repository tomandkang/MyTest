package com.example.testcommon.commom.algorithm.sorts;

import com.alibaba.fastjson.JSON;

import java.util.Random;

public class TopKSort {

    //10亿数字.
    public static int LEN = 1000;
    //TOP 1000
    public static int TOP = 5;
    //10亿数字数组
    public static int arr[] = new int[LEN];
    //TOP1000的小顶堆数组
    public static int res[] = new int[TOP];

    static {
        for (int i = 0; i < LEN; i++) {
            arr[i] = new Random().nextInt(100);
        }
    }


    public static void topKSort() {
        //构建初始堆
        for (int i = 0; i < TOP; i++) {
            res[i] = arr[i];
        }
        for (int i = res.length / 2 - 1; i >= 0; i--) {
            adjustHead(res, i, res.length);
        }
        for (int i = TOP; i < LEN; i++) {
            if (arr[i] > res[0]) {
                res[0] = arr[i];
                adjustHead(res, 0, res.length);
            }
        }
        System.err.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(arr));
    }


    private static void adjustHead(int[] nums, int index, int length) {
        int temp = nums[index];
        for (int k = 2 * index + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k + 1] < nums[k]) {
                k++;
            }
            if (nums[k] < temp) {
                nums[index] = nums[k];
                index = k;
            } else {
                break;
            }
        }
        nums[index] = temp;
    }


}
