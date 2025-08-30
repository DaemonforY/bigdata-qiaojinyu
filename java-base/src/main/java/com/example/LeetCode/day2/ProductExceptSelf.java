package com.example.LeetCode.day2;

/**
 * 解决“除自身以外数组的乘积”问题的类
 * 给定一个数组 nums，返回一个新数组 output，
 * 其中 output[i] 等于 nums 中除了 nums[i] 之外所有其他元素的乘积
 */
public class ProductExceptSelf {
    /**
     * 计算除自身以外数组的乘积
     *
     * @param nums 输入的整数数组
     * @return 一个新数组，其中每个元素等于原数组中除该位置元素以外所有其他元素的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 第一次遍历：计算前缀乘积（i左侧所有元素的乘积）
        result[0] = 1;  // 第一个元素左侧没有元素，乘积为1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 第二次遍历：计算后缀乘积（i右侧所有元素的乘积）并与前缀乘积相乘
        int suffixProduct = 1;  // 最后一个元素右侧没有元素，乘积为1
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();

        // 测试案例1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        // 输出: [24, 12, 8, 6]
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 测试案例2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        // 输出: [0, 0, 9, 0, 0]
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
