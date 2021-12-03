package com.example.demo.commom.SortTest;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,2,6,8,19,7,9,12,45,65,32,24,17};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.println("第一次提交");

        System.out.println("第二次提交");

        System.out.println("第三次提交");

        System.out.println("你爹");

        System.out.println("尼玛");

        System.out.println("老哥");

    }


    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void quick(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){return;}
        i=low;
        j=high;
        temp=arr[i];
        while(j>i){
            while(j>i&&arr[j]>=temp){
                j--;
            }
            while(j>i&&arr[i]<=temp){
                i++;
            }
            if(i<j){
              swap(arr,i,j);
            }
        }
        arr[low]=arr[i];
        arr[i]=temp;
        quick(arr,low,j-1);
        quick(arr,j+1,high);
    }

}
