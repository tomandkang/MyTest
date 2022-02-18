package com.example.demo.commom.ObjectTest;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mytest_3 {
    public static void main(String[] args) {
        //0000 0000 0000 0000 0000 0000 0000 0101
        //0000 0000 0000 0000 0000 0000 0000 0101
        //0000 0000 0000 0000 0000 0000 0000 0101

        int i=5;
        i=i|5;


        System.out.println(i);
    }


    public static boolean isValidSudoku(char board[][]) {
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                int k = i / 3 * 3 + j / 3;
                System.out.println(k);
            }
        }
        return true;
    }


    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public static int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public static ListNode addTwoNumbers() {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        for (int i = 11; i < 15; i++) {
            ListNode sumNode = new ListNode(i % 10);
            cursor.next = sumNode;
            cursor = sumNode;
        }
        return root;
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring_1(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


    //双指针解决
    public static int removeDuplicates(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < A.length; right++)
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩
            //指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right])
                A[++left] = A[right];

        System.out.println(JSON.toJSONString(A));
        return ++left;
    }


}
