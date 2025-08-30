package com.example.LeetCode.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * 解决最长无重复字符子串问题的类
 */
public class LongestSubstring {
    /**
     * 计算给定字符串中最长无重复字符子串的长度
     *
     * @param s 输入的字符串
     * @return 最长无重复字符子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合用于存储当前窗口中的字符，快速判断是否有重复
        Set<Character> charSet = new HashSet<>();
        // 字符串长度
        int n = s.length();
        // 右指针，初始值为-1，表示窗口的右边界还未开始
        int right = -1;
        // 最长子串的长度
        int maxLength = 0;

        // 左指针遍历字符串，作为窗口的左边界
        for (int left = 0; left < n; left++) {
            // 左指针右移时，移除窗口中对应的字符
            if (left != 0) {
                charSet.remove(s.charAt(left - 1));
            }

            // 尽可能扩大右指针，直到遇到重复字符
            while (right + 1 < n && !charSet.contains(s.charAt(right + 1))) {
                charSet.add(s.charAt(right + 1));
                right++;
            }

            // 更新最长子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();

        // 测试案例1
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));  // 输出: 3
        // 测试案例2
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));     // 输出: 1
    }
}
