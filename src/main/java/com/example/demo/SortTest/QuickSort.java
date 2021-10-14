package com.example.demo.SortTest;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,2,6,8,19,7,9,12,45,65,32,24,17};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,p,temp;
        if(low>high){
            return;
        }
        //指针
        p=arr[low];
        i=low;
        j=high;
        while(i<j){
            while(arr[j]>=p&&j>i){
                j--;
            }
            while(arr[i]<=p&&j>i){
                i++;
            }
            if(j>i){
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        arr[low]=arr[i];
        arr[i]=p;
       quickSort(arr,low,j-1);
       quickSort(arr,j+1,high);


    }


}
