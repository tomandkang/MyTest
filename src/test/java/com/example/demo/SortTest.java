package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.commom.sorts.*;
import org.junit.jupiter.api.Test;

public class SortTest extends DemoApplicationTests {

    private static final int a[] = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    private static final int arr[] = {4, 8, 7, 5, 6};

    @Test
    public void test_0() throws Exception {
        BubbleSort.bubbleSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void test_1() throws Exception {
        SelectionSort.selectionSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void test_2() throws Exception {
        InsertionSort.insertionSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void test_3() throws Exception {
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void test_4() throws Exception {
        HeapSort.heapSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    @Test
    public void test_5() throws Exception {
        HeadSortCkw.headSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
    @Test
    public void test_6(){
        TopKSort.topKSort();

    }

}
