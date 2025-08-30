package com.example.LeetCode.day1;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    /**
     * 寻找最长连续序列的长度
     *
     * @param nums 输入的整数数组
     * @return 返回最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        // 处理空数组情况
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 创建一个HashSet存储所有数字，用于O(1)时间复杂度的查找
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // 初始化最长连续序列的长度为0
        int maxLength = 0;

        // 遍历每个数字
        for (int num : numSet) {
            // 只有当num-1不存在时，才将num视为一个新序列的起点
            // 这一步是关键，确保每个序列只被处理一次
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 查找连续的下一个数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // 更新最长序列长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        // 返回最长连续序列的长度
        return maxLength;
    }


    public static void main(String[] args) {
        LongestConsecutive solution = new LongestConsecutive();

        // 测试案例1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums1));  // 输出: 4

        // 测试案例2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums2));  // 输出: 9

        // 测试案例3
        int[] nums3 = {1, 0, 1, 2};
        System.out.println(solution.longestConsecutive(nums3));  // 输出: 3
    }
}
