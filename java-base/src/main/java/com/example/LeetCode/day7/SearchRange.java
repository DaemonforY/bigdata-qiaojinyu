package com.example.LeetCode.day7;


public class SearchRange {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 元素的第一个和最后一个位置，如果未找到则返回{-1, -1}
     */
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1}; // nums 中没有 target
        }
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    /**
     * 使用二分查找寻找下界
     *
     * 返回最小的满足 nums[i] >= target 的下标 i
     * 如果数组为空，或者所有数都 < target，则返回 nums.length
     * 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 最小的满足条件的下标
     */
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid; // 范围缩小到 [left, mid)
            } else {
                left = mid + 1; // 范围缩小到 [mid+1, right)
            }
        }
        // 循环结束后 left = right
        // 此时 nums[left-1] < target 而 nums[left] = nums[right] >= target
        // 所以 left 就是第一个 >= target 的元素下标
        return left;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ans = searchRange.searchRange(nums, 8);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

