package com.example.testcommon.commom.algorithm.sorts;

public class InsertionSort {


    /**
     * @description: 插入排序法
     * @author: chenkangwen
     * @date: 2024/11/27
     * @param: [nums]
     */
    public static void insertionSort(int[] nums) {
        int temp, j;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            j = i - 1;
            while ((j >= 0) && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
