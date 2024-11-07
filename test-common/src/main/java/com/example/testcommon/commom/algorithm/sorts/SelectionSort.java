package com.example.testcommon.commom.algorithm.sorts;

public class SelectionSort {


    /**
     * @description:
     * @author: chenkangwen
     * @date: 2024/11/27
     * @param: [nums]
     */
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }


}
