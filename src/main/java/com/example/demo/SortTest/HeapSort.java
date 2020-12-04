package com.example.demo.SortTest;

import com.example.demo.AnnotationTest.MyField;
import com.example.demo.ObjectTest.Father;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HeapSort {


        public static void heap(int[] arr,int i,int length){
                int temp=arr[i];
                for(int k=i*2+1;k<length;k=k*2+1){
                    if(k+1<length&&arr[k]<arr[k+1]){
                        k++;
                    }
                    if(arr[k]>temp){


                    }
                }

        }


        public static void swap(int[] arr,int i,int j){
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }

}
