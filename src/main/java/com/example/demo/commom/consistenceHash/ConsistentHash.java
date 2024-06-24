package com.example.demo.commom.consistenceHash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: chenkangwen
 * @CreateTime: 2024-06-21  11:21
 * @Description:
 * @Version: 1.0
 */
public class ConsistentHash {

    private final int numberOfReplicas;// 每个机器节点关联的虚拟节点个数
    private final SortedMap<Integer, Node> circle = new TreeMap<>();// 环形虚拟节点

    /**
     * hash 函数接口
     *
     * @param numberOfReplicas 每个机器节点关联的虚拟节点个数
     * @param nodes            真实机器节点
     */
    public ConsistentHash(int numberOfReplicas, Collection<Node> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (Node node : nodes) {
            add(node);
        }
    }

    /**
     * 增加真实机器节点
     *
     * @param node
     */
    public void add(Node node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.put(this.hash(node.getIp() + i), node);
        }
    }

    /**
     * 删除真实机器节点
     *
     * @param node
     */
    public void remove(Node node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.remove(this.hash(node.getIp() + i));
        }
    }

    /**
     * 取得真实机器节点
     *
     * @param key
     * @return
     */
    public Node get(String key) {
        if (circle.isEmpty()) {
            return null;
        }

        Integer hash = this.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, Node> tailMap = circle.tailMap(hash);// 沿环的顺时针找到一个虚拟节点
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        return circle.get(hash); // 返回该虚拟节点对应的真实机器节点的信息
    }


    public Integer hash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

}
