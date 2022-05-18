package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.commom.sorts.BubbleSort;
import com.example.demo.commom.sorts.InsertionSort;
import com.example.demo.commom.sorts.QuickSort;
import com.example.demo.commom.sorts.SelectionSort;
import org.junit.jupiter.api.Test;

public class SortTest extends DemoApplicationTests {

    private static final int a[] = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

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
        QuickSort.quickSort(a,0,a.length-1);
        System.out.println(JSON.toJSONString(a));
    }
}
