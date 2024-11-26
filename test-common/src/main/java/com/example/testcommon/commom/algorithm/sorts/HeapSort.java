package com.example.testcommon.commom.algorithm.sorts;

public class HeapSort {


    public static void heapSort(int[] array) {
        //从倒数第一个非叶子节点开始
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            //从第一天非叶子节点从下至上，从左至右调整结构
            adjustHeap(array, i, array.length);
        }

        //将堆顶元素与末尾元素交换 将最大元素沉到数组末尾 + 重新调整堆结构
        for (int i = array.length - 1; i > 0; i--) {
            //交换堆顶元素和末尾元素
            swap(array, 0, i);
            //交换后的末尾元素忽略(j--) 不再参与堆结构的调整
            //重新调整堆结构
            adjustHeap(array, 0, i);
        }

    }

    /**
     * @description:
     * @author: chenkangwen
     * @date: 2024/11/26
     * @param: [array, index, length]
     */
    public static void adjustHeap(int[] array, int i, int length) {
        //取出当前元素
        int temp = array[i];
        //i节点是index节点的左子节点
        for (int k = 2 * i + 1; k < length; k = 2 * i + 1) {
            //表明左子节点小于右子节点
            if (k + 1 < length && array[k] < array[k + 1]) {
                //将指针移至较大节点
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
