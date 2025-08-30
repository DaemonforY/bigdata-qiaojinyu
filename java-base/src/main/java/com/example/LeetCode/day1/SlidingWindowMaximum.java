package com.example.LeetCode.day1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

/**
 * 解决滑动窗口最大值问题的类
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class SlidingWindowMaximum {
    /**
     * 计算滑动窗口中的最大值
     *
     * @param nums 数组，包含整数
     * @param k    窗口大小
     * @return 滑动窗口中的最大值数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 处理边界情况
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // 双端队列，用于存储元素的索引，保持队列中元素对应的数值单调递减
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 移除队列中超出当前窗口范围的元素（索引小于i-k+1的元素）
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除队列中所有小于当前元素的元素
            // 因为它们不可能成为后续窗口的最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前元素的索引加入队列
            deque.offerLast(i);

            // 当窗口完全形成后，队列的头部就是当前窗口的最大值
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        // 测试案例
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);

        // 输出结果：[3, 3, 5, 5, 6, 7]
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
