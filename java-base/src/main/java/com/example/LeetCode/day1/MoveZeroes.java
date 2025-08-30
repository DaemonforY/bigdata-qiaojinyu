package com.example.LeetCode.day1;

import java.util.Arrays;

class MoveZeroes {
    /**
     * 将数组中的所有零移动到末尾，同时保持非零元素的相对顺序
     * 通过两个指针来实现：一个用于遍历数组，另一个用于记录非零元素应该放置的位置
     *
     * @param nums 输入的整数数组
     */
    public void moveZeroes(int[] nums) {
        // 第一个指针：记录非零元素应该放置的位置
        int nonZeroIndex = 0;

        // 遍历数组，将所有非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不为零，则将其放到nonZeroIndex位置，并将nonZeroIndex后移
            if (nums[i] != 0) {
                // 将非零元素放到nonZeroIndex位置
                nums[nonZeroIndex] = nums[i];
                // 移动非零元素指针
                nonZeroIndex++;
            }
        }

        // 从nonZeroIndex位置开始，将剩余位置填充为0
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();

        // 测试案例1
        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));  // 输出: [1, 3, 12, 0, 0]

        // 测试案例2
        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));  // 输出: [0]
    }
}

