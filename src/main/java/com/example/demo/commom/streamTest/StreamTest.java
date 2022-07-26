package com.example.demo.commom.streamTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamTest {


    public static void main(String[] args) throws Exception {
        readFile("D:\\新建文件夹\\20220712104943_1284.ndjson");
    }

     public static void readFile(String filePath){
         try (InputStream inputStream = new FileInputStream(new File(filePath));
              InputStreamReader reader = new InputStreamReader(inputStream);
              BufferedReader br = new BufferedReader(reader)) {
             String jsonStr;
             while ((jsonStr=br.readLine())!=null){
                 System.out.println(jsonStr);
             }
         } catch (Exception e) {
         }
     }

}
