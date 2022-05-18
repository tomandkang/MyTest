package com.example.demo.commom.sorts;

public class BubbleSort {

    /**
     *
     * @Param: [nums]
     * @Return: void
     * @Date: 2022/5/18
     * @Author: chenkangwen
     * @Desc:
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
