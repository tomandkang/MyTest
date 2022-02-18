package com.example.demo.commom.ObjectTest;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/15 11:10
 **/
public class Mytest {

    private static final String TARGET_STRING="<span style=\"background-color: rgb(255, 255, 0);\">%s</span>";

    public static void main(String args[]) throws IOException {
        Son son = new Son();
        son.setName("张三");
        son.setAge(18);
        son.setSchool("小比崽子");

        Son son1 = new Son();
        son1.setName("李四");
        son1.setAge(19);
        son1.setSchool("小比崽子");


       List<Son> sons = new ArrayList<>();
       sons.add(son);
       sons.add(son1);
       sons.add(null);

        List<Son> collect = sons.stream().filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }

    private static String readFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader input = new FileReader(filename);
        BufferedReader bufRead = new BufferedReader(input);
        try {
            String line = bufRead.readLine();
            while (line != null) {
                sb.append(line).append('\n');
                line = bufRead.readLine();
            }
        } finally {
            bufRead.close();
            input.close();
        }
        return sb.toString();
    }


    public static void different(String beforeFixing,String afterFixing){
        DiffMatchPatch diffs = new DiffMatchPatch();
        LinkedList<DiffMatchPatch.Diff> diffList = diffs.diff_main(beforeFixing, afterFixing);
        for (DiffMatchPatch.Diff diff:diffList){
            if(DiffMatchPatch.Operation.EQUAL==diff.operation){
                continue;
            }
            if(DiffMatchPatch.Operation.INSERT==diff.operation){
                String text= diff.text;
                String format = String.format(TARGET_STRING, text);
                afterFixing=afterFixing.replaceAll(text,format);
            }
            if(DiffMatchPatch.Operation.DELETE==diff.operation){
                String text= diff.text;
                String format = String.format(TARGET_STRING, text);
                beforeFixing= beforeFixing.replaceAll(text,format);
            }

        }
        System.out.println("beforeFixing:"+beforeFixing);
        System.out.println("afterFixing:"+afterFixing);
    }

}


