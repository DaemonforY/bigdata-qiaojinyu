package com.example.LeetCode.day1;

/**
 * 和为K的子数组
 * 该类提供了一个方法来计算一个整数数组中所有和为给定值K的连续子数组的数量
 * */
public class SubarraySum {
    /**
     * 计算和为K的子数组数量
     *
     * @param nums 一个整数数组
     * @param k    目标和
     * @return 和为K的子数组数量
     *
     * 该方法通过双重循环遍历数组中的所有可能子数组，并计算它们的和
     * 当子数组的和等于给定的目标和K时，计数器增加
     * */
    public int subarraySum(int[] nums, int k) {
        // 初始化计数器为0
        int count = 0;
        // 外层循环遍历数组，从每个元素开始
        for (int start = 0; start < nums.length; start++) {
            // 初始化当前子数组的和为0
            int sum = 0;
            // 内层循环从当前元素开始，向前遍历所有可能的子数组
            for (int end = start; end >= 0; end--) {
                // 累加当前子数组的和
                sum += nums[end];
                // 如果当前子数组的和等于目标和K，计数器增加
                if (sum == k) {
                    count++;
                }
            }
        }
        // 返回和为K的子数组数量
        return count;
    }

    /**
     * 主方法用于测试
     *
     * 该方法测试了两个例子，以验证subarraySum方法的正确性
     * */
    public static void main(String[] args) {
        // 创建SubarraySum类的实例
        SubarraySum subarraySum = new SubarraySum();
        // 测试例子1
        System.out.println(subarraySum.subarraySum(new int[]{1, 1, 1}, 2));
        // 测试例子2
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
