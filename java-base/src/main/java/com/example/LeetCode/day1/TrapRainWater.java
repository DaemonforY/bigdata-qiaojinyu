package com.example.LeetCode.day1;

/**
 * 解决接雨水问题的类
 * 计算给定高度数组能接住多少雨水
 */
public class TrapRainWater {

    /**
     * 计算指定高度数组能接住的雨水总量
     *
     * @param height 高度数组，代表每个位置的柱子高度
     * @return 接住的雨水总量
     */
    public int trap(int[] height) {
        // 处理边界情况
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;                  // 左指针，从数组起始位置开始
        int right = height.length - 1; // 右指针，从数组末尾开始
        int leftMax = 0;               // 左侧已遍历的最大高度
        int rightMax = 0;              // 右侧已遍历的最大高度
        int water = 0;                 // 接住的雨水总量

        // 使用双指针向中间遍历
        while (left < right) {
            // 左侧柱子较矮，移动左指针
            if (height[left] < height[right]) {
                // 更新左侧最大高度
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // 当前位置能接住的雨水 = 左侧最大高度 - 当前柱子高度
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // 右侧柱子较矮，移动右指针
                // 更新右侧最大高度
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // 当前位置能接住的雨水 = 右侧最大高度 - 当前柱子高度
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        TrapRainWater solution = new TrapRainWater();

        // 测试案例1
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height1));  // 输出: 6

        // 测试案例2
        int[] height2 = {4,2,0,3,2,5};
        System.out.println(solution.trap(height2));  // 输出: 9
    }
}
