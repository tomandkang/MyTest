package com.example.demo.commom.sortTest;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/4/8 19:20
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr={2,19,12,5,8,24,9,1,11};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr){
        for(int j=0;j<arr.length;j++){
            for (int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
}
