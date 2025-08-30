package com.example.LeetCode.day2;

/**
 * 旋转数组类
 * 提供方法将数组元素向右轮转 k 步
 * 给定一个整数数组 nums，
 * 将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RotateArray {
    /**
     * 将给定数组向右轮转 k 步
     *
     * @param nums 原始数组
     * @param k    轮转步数
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // 处理 k 大于数组长度的情况，轮转 n 次等于没有轮转
        k = k % n;

        // 三次反转法
        // 1. 反转整个数组
        reverse(nums, 0, n - 1);
        // 2. 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 3. 反转剩余元素
        reverse(nums, k, n - 1);
    }

    /**
     * 辅助方法：反转数组中从 start 到 end 的元素
     *
     * @param nums 原始数组
     * @param start 开始索引
     * @param end   结束索引
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换 start 和 end 位置的元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // 移动指针
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        // 测试案例
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);

        // 输出结果：[5, 6, 7, 1, 2, 3, 4]
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
