package com.example.LeetCode.day2;

/**
 * 解决最大子数组和问题的类
 * 给你一个整数数组 nums ，
 * 找出一个数具有最大和的连续子数组（子组最少包含一个元素），返回其最大和。
 */
public class MaximumSubarray {
    /**
     * 寻找数组中连续子数组的最大和
     *
     * @param nums 输入的整数数组
     * @return 返回连续子数组的最大和
     */
    public int maxSubArray(int[] nums) {
        // 处理空数组情况
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 当前子数组的最大和
        int currentMax = nums[0];
        // 全局最大和
        int globalMax = nums[0];

        // 从数组的第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 决策：是将当前元素加入之前的子数组，还是以当前元素为起点重新开始一个子数组
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // 更新全局最大和
            globalMax = Math.max(globalMax, currentMax);
        }

        // 返回全局最大和
        return globalMax;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        // 测试案例
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 输出最大子数组和
        System.out.println(solution.maxSubArray(nums));  // 输出: 6
    }
}
