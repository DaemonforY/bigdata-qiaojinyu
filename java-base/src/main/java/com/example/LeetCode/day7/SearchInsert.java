package com.example.LeetCode.day7;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // 初始化左右指针和答案变量
        int left = 0, right = n - 1, ans = n;
        // 当左指针不大于右指针时，执行二分查找
        while (left <= right) {
            // 计算中间位置，使用位运算避免整数溢出
            int mid = ((right - left) / 2) + left;
            // 如果目标值小于等于中间位置的值，调整右指针，并更新答案
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                // 如果目标值大于中间位置的值，调整左指针
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

}