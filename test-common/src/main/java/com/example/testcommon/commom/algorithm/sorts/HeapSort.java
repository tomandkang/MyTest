package com.example.testcommon.commom.algorithm.sorts;

public class HeapSort {


    /**
     * @description: 堆排序算法
     * @author: chenkangwen
     * @date: 2024/11/27
     * @param: [array]
     */
    public static void heapSort(int[] array) {

        for (int i = array.length / 2 - 1; i >= 0; i--) {

            adjustHeap(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {

            swap(array, 0, i);

            adjustHeap(array, 0, i);
        }

    }

    /**
     * @description: 调整堆顶
     * @author: chenkangwen
     * @date: 2024/11/26
     * @param: [array, index, length]
     */
    public static void adjustHeap(int[] array, int i, int length) {

        int temp = array[i];

        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

            if (k + 1 < length && array[k] < array[k + 1]) {

                k++;
            }
            if (array[k] <= temp) {

                break;
            }
            array[i] = array[k];

            i = k;
        }

        array[i] = temp;
    }

    /**
     * @description: 交换下标a, b的值;
     * @author: chenkangwen
     * @date: 2024/11/26
     * @param: [nums, a, b]
     */
    private static void swap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
}
