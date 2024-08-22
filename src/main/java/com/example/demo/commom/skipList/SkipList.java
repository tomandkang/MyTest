package com.example.demo.commom.skipList;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: chenkangwen
 * @CreateTime: 2024-07-15  18:01
 * @Description:
 * @Version: 1.0
 */
public class SkipList {


    // 最大层数
    static final int MAX_LEVEL = 32;
    // 节点上升的概率
    static final double P_FACTOR = 0.25;
    // 跳表节点，存储元素的基本单位
    private SkiplistNode head;
    // 当前最大层
    private int level;
    // 随机概率
    private Random random;

    public SkipList() {
        // 跳表存储空间初始化
        this.head = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    /**
     * 跳表查询API
     * 从最大层 level 开始查找，在当前层水平逐个比较，
     * 直到当前节点的下一个节点大于等于目标节点，然后移动至下一层，
     * 重复这个过程直到到达第一层。
     * 此时，若第一层的下一个节点的值等于target，则返回 true;反之返回 false
     *
     * @param target
     * @return
     */
    public boolean search(int target) {
        // 指向虚拟头节点
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* 找到第 i 层小于且最接近 num 的元素*/
            while (curr.next[i] != null && curr.next[i].val < target) {
                curr = curr.next[i];
            }
        }
        // 经过上面的遍历，curr 现在指向第一层 最后一个小于 target 的节点，
        // 因此现在向后移一位到达第一个大于或等于 target 的节点。
        curr = curr.next[0];
        // target 存在
        if (curr != null && curr.val == target) {
            return true;
        }
        return false;
    }

    /**
     * 跳表插入API
     * 从最大层 level 开始查找，在当前层水平逐个比较，
     * 直到当前节点的下一个节点大于等于目标节点，然后移动至下一层，
     * 重复这个过程直到到达第一层。
     * 设新加入的节点为 newNode，我们需要计算出此次节点插入的层数 lv，
     * 如果 level 小于 lv，则同时需要更新 level。
     * 用数组 update 保存每一层查找的最后一个节点，
     * 第 i 层最后的节点为 update[i]。我们将 newNode 的后续节点指向 update[i] 的下一个节点，
     * 同时更新 update[i]update[i]update[i] 的后续节点为 newNode
     *
     * @param num
     */
    public void add(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(update, head);
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* 找到第 i 层小于且最接近 num 的元素*/
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }
            /* 记录每一层最后一个小于 num 的节点 */
            update[i] = curr;
        }
        // 节点在 P_FACTOR 概率下可能上升的层数，最大上升 MAX_LEVEL 层
        int lv = randomLevel();
        // 更新当前最大节点
        level = Math.max(level, lv);
        // 生成 num 跳表节点，该节点有 lv 层, 进行插入
        SkiplistNode newNode = new SkiplistNode(num, lv);
        for (int i = 0; i < lv; i++) {
            /* 新节点第 i 层的 next 节点指向 update[i] 的 next */
            newNode.next[i] = update[i].next[i];
            /* update[i] 的 next 指向 newNode */
            update[i].next[i] = newNode;
        }
    }

    /**
     * 跳表删除API
     * 首先查找当前元素是否在跳表中。如果在：
     * 用数组 update 保存每一层最后一个大于等于 target 的节点，
     * 第 i 层最后的节点为 update[i]
     * 此时，第 i 层的下一个节点的值为 num， 需要进行删除
     * 由于第 i 层的以 p 的概率出现在第 i + 1 层，因此应当从第 1 层
     * 开始向上进行更新，将 num 从 update[i] 的下一条中删除
     * 同时更新 update[i] 的后续节点，直到当前层的链表中没有出现 num 的节点位置。
     * 最后还需要更新跳表中当前的最大层数 level
     *
     * @param num
     * @return
     */
    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* 找到第 i 层小于且最接近 num 的元素*/
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }
            update[i] = curr;
        }
        // curr 指向第 1 层 要删除的 num 节点
        curr = curr.next[0];
        /* 如果值不存在则返回 false */
        if (curr == null || curr.val != num) {
            return false;
        }
        // 从第一层开始，向上删除 num 节点
        for (int i = 0; i < level; i++) {
            // 上面没有了，说明 num 不在上升了，删除完了
            if (update[i].next[i] != curr) {
                break;
            }
            // 删除节点
            update[i].next[i] = curr.next[i];
        }
        // 更新当前的 level
        while (level > 1 && head.next[level - 1] == null) {
            level--;
        }
        return true;
    }

    /**
     * 功能：返回一个新插入的节点可能会上升的层数
     */
    private int randomLevel() {
        int lv = 1;
        /*
            随机生成 lv
         */
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

    // 跳表节点，存储元素，一个元素最大可能有 maxLevel 层
    class SkiplistNode {
        int val;
        // 指向后面的指针，由于一个元素可能占据多层，所以有多个，
        SkiplistNode[] next;

        public SkiplistNode(int val, int maxLevel) {
            this.val = val;
            this.next = new SkiplistNode[maxLevel];
        }
    }


}
