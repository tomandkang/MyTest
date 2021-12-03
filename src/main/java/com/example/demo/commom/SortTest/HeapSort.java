package com.example.demo.commom.SortTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HeapSort {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


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

    public static void main(String[] args) {
            getZeroTime(0);
            getZeroTime(1);

        System.out.println(simpleDateFormat.format(getZeroTime(0)));
        System.out.println(simpleDateFormat.format(getZeroTime(1)));
    }

    public static Date getZeroTime(int days){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
