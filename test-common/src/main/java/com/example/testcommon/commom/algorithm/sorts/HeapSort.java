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




    // 堆排序方法
    public static void heapSortAlgorithm(int[] arr) {
        int n = arr.length;
        // 构建大根堆，
        // 这段代码是构建大根堆的过程，它的循环次数为n/2-1次，是因为在完全二叉树中，叶子节点不需要进行堆化操作，
        // 所以只需要对非叶子节点进行堆化，而非叶子节点的数量为n/2-1个。因此，只需要循环n/2-1次即可完成大根堆的构建。
        // 非叶子节点在一维数组中就是前面 n/2-1
        for (int i = n / 2 - 1; i >= 0; i--) {
            // 从最底层的根节点开始堆化，每次执行完成后，都找出最大值，并放在根节点位置
            // 逐层往上找，循环结束后，第一个元素肯定是最大值
            heapify(arr, n, i);
        }
        // 依次取出堆顶元素，并将余下元素继续堆化，得到有序序列
        for (int i = n - 1; i >= 0; i--) {
            // 第一个for循环已经找出最大值，所以先做交货，把最大值换到最后一个位置
            // 把最大值交换到最后一个位置，下一次循环最后一个位置就不比较了
            swap(arr, 0, i);
            // 继续找出最大值，放在第一个位置
            heapify(arr, i, 0);
        }
    }


    /**
     * @description:
     * @author: chenkangwen
     * @date: 2024/8/28
     * @param: [arr, size, i]
     */
    private static void heapify(int[] arr, int size, int i) {
        int largest = i; // 初始化假设最大值为根节点
        int left = 2 * i + 1; // 相对于索引i的左节点索引
        int right = 2 * i + 2; // 相对于索引i的右节点索引
        // 找到左右子节点中的最大值
        if (left < size && arr[left] > arr[largest]) {
            // 如果有左节点，且左节点大于根节点，则记录左节点为最大值
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            // 如果有右节点，且右节点大于最大值，则记录右节点为最大值
            largest = right;
        }
        // 上面两个if之后，肯定找到最大值
        if (largest != i) {
            // i 是根节点下标
            // 如果最大值不是根节点，则交换根节点与最大值节点，
            // 并递归地对最大值节点进行堆化
            swap(arr, i, largest);
            heapify(arr, size, largest);
        }
    }

}
