package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

public class AlgorithmTest extends DemoApplicationTests {

    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(nums);
        System.err.println(JSON.toJSONString(nums));
    }

    //双指针解决
    public int removeDuplicates(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < A.length; right++) {
            if (A[left] != A[right]) {
                A[++left] = A[right];
            }
        }
        return ++left;
    }

    //判断数组是否重复
    @Test
    public void test_1() {
        Boolean judge = judge();
        System.out.println(judge);
    }

    public Boolean judge(){
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


}
