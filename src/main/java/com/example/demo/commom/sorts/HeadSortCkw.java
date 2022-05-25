package com.example.demo.commom.sorts;

public class HeadSortCkw {


    public static void headSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHead(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swip(nums, 0, i);
            adjustHead(nums, 0, i);
        }
    }

    public static void adjustHead(int[] nums, int index, int length) {
        int temp = nums[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > temp) {
                nums[index] = nums[i];
                index = i;
            } else {
                break;
            }
        }
        nums[index] = temp;
    }

    public static void swip(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
