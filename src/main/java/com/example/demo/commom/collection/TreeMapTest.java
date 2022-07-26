package com.example.demo.commom.collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, String> treemap = new TreeMap<>();
        SortedMap<Integer, String> treemapincl;

        //populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");


        treemapincl = treemap.tailMap(3);
        System.out.println("Tail map values: " + treemapincl);

        treemapincl = treemap.headMap(3);
        System.out.println("Head map values: " + treemapincl);

        System.out.println("First key is: " + treemap.firstKey());
        System.out.println("Last key is: " + treemap.lastKey());
    }
}
