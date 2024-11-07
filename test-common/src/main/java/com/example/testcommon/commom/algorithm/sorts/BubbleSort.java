package com.example.testcommon.commom.algorithm.sorts;

/**
 * @description: 冒泡算法
 * @author: chenkangwen
 * @date: 2024/11/26
 */
public class BubbleSort {

    /**
     * @description: 冒泡算法
     * @author: chenkangwen
     * @date: 2024/8/28
     * @param: [nums]
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                swap(nums, j, j + 1);
            }
        }
    }

    /**
     * @description: 交换下标a, b的值;
     * @author: chenkangwen
     * @date: 2024/11/26
     * @param: [nums, a, b]
     */
    public static void swap(int[] nums, int start, int end) {
        if (nums[end] > nums[start]) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
        }
    }


}
