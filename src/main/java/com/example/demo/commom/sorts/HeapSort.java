package com.example.demo.commom.sorts;

public class HeapSort {

    /**
     * 二叉树要点
     * 大顶堆:arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆:arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     * 最大左节点:array.length/2-1
     * 最大右节点:array.length/2-2
     */
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

    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void adjustHeap(int[] array, int index, int length) {
        //取出当前元素
        int temp = array[index];
        //i节点是index节点的左子节点
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //表明左子节点小于右子节点
            if (i + 1 < length && array[i] < array[i + 1]) {
                //将指针移至较大节点
                i++;
            }

            //如果子节点大于父节点
            if (array[i] > temp) {
                //将较大值赋给当前节点
                array[index] = array[i];
                //指针移向子节点
                index = i;
            } else {
                break;
            }
        }
        //循环结束，已经将最大值放在了堆顶
        //将temp值放到最终的位置
        array[index] = temp;

    }

}
