package com.example.testcommon.commom.algorithm.sorts;

public class QuickSort {


    public static void quickSort(int[] arr, int left, int right) {
        int i, j, temp, t;
        if (left > right) {
            return;
        }
        i = left;
        j = right;
        //temp就是基准位
        temp = arr[left];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, left, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, right);
    }

    private static void quickSort2(int[] arr, int start, int end) {
        // 递归终止条件
        if (start >= end) {
            return;
        }
        // 第一步，找出分区后枢轴的下标，比如[2,1,3],枢轴为2，分区后枢轴的下标为1
        int pivotIndex = partition(arr, start, end);
        // 第二步，对左子数组排序
        quickSort(arr, start, pivotIndex - 1);
        // 第三步，对右子数组排序
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // 确定枢轴元素
        int pivot = arr[start];
        // 定义两个指针（引用），一个指向数组左端，一个指向数组右端
        int left = start;
        int right = end;
        while (left < right) {
            // 从右往左扫描，寻找比枢轴元素小的，并填入坑中
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            // 从左往右扫描，寻找比枢轴元素大的，并填入新坑中
            while (left < right && arr[left] < pivot) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        // 扫描完成后,将枢轴元素填入新坑中
        arr[left] = pivot;
        return left;
    }

}
