package com.example.LeetCode.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解决三数之和问题的类
 */
public class ThreeSum {
    /**
     * 寻找数组中所有不重复的三元组，这些三元组的和为零
     * 
     * @param nums 输入的整数数组
     * @return 返回一个列表，包含所有和为零的不重复三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 创建结果列表
        List<List<Integer>> result = new ArrayList<>();

        // 处理边界情况
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序数组，为双指针和去重做准备
        Arrays.sort(nums);

        // 遍历数组，固定第一个元素
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的第一个元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 如果第一个元素大于0，三数之和不可能为0，直接退出
            if (nums[i] > 0) {
                break;
            }

            // 双指针初始化
            int left = i + 1;
            int right = nums.length - 1;

            // 寻找符合条件的三元组
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到符合条件的三元组，添加到结果中
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的左元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 跳过重复的右元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动双指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和小于0，需要增大，移动左指针
                    left++;
                } else {
                    // 和大于0，需要减小，移动右指针
                    right--;
                }
            }
        }

        // 返回结果列表
        return result;
    }

    /**
     * 主函数，用于测试三数之和的方法
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // 测试案例
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);  // 输出: [[-1, -1, 2], [-1, 0, 1]]
    }
}
