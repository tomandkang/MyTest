package com.example.demo.TestClass;

import java.util.ArrayList;
import java.util.List;

public class Test2Class {


    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>();
        longs.add(1l);
        longs.remove(2l);
        System.out.println(longs.size());
    }
}
