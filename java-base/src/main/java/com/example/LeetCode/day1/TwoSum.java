package com.example.LeetCode.day1;

import java.util.HashMap;
import java.util.Map;
/**
 *给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * */
public class TwoSum {
    /**
     * 寻找数组中两个数之和等于目标值的索引
     *
     * @param nums 输入的整数数组
     * @param target 目标值
     * @return 返回包含这两个数的索引的数组
     */
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表存储数值和对应的索引
        Map<Integer, Integer> numMap = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算需要的互补数
            int complement = target - nums[i];

            // 检查互补数是否已在哈希表中
            //containsKey()判断当前 Map 集合中是否包含指定的键（key）
            if (numMap.containsKey(complement)) {
                // 找到则返回两个数的索引
                return new int[] { numMap.get(complement), i };
            }

            // 未找到则将当前数值和索引存入哈希表
            numMap.put(nums[i], i);
        }

        // 题目保证有解，理论上不会执行到这里
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // 测试案例
        int[] result1 = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // [0, 1]

        int[] result2 = solution.twoSum(new int[] {3, 2, 4}, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // [1, 2]

        int[] result3 = solution.twoSum(new int[] {3, 3}, 6);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // [0, 1]
    }
}
