package com.example.LeetCode.day9;

import java.util.*;

public class TopKFrequent {
/**
 * 获取数组中出现频率最高的k个元素
 *
 * @param nums 表示输入的整数数组
 * @param k 表示需要获取的频率最高的元素个数
 * @return 返回一个整数数组，包含出现频率最高的k个元素
 */
public int[] topKFrequent(int[] nums, int k) {
    // 使用HashMap记录每个元素出现的次数
    Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
    for (int num : nums) {
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    // 使用优先队列（最小堆）来维护出现次数最多的k个元素
    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
        public int compare(int[] m, int[] n) {
            return m[1] - n[1];
        }
    });
    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
        int num = entry.getKey(), count = entry.getValue();
        // 如果队列已满，且当前元素的出现次数比队列中最小的元素大，则替换之
        if (queue.size() == k) {
            if (queue.peek()[1] < count) {
                queue.poll();
                queue.offer(new int[]{num, count});
            }
        } else {
            // 如果队列未满，直接加入队列
            queue.offer(new int[]{num, count});
        }
    }
    // 将优先队列中的元素转移到结果数组中
    int[] ret = new int[k];
    for (int i = 0; i < k; ++i) {
        ret[i] = queue.poll()[0];
    }
    return ret;
}

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] ret = topKFrequent.topKFrequent(nums, k);
        System.out.println(Arrays.toString(ret));
    }
}