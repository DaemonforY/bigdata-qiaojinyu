package com.example.LeetCode.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解决方案类，用于寻找字符串中的所有异位词
 */
public class FindAnagrams {

    /**
     * 寻找字符串s中所有p的异位词的起始索引
     * @param s 输入字符串
     * @param p 目标异位词字符串
     * @return 返回一个列表，包含所有异位词的起始索引
     */
    public List<Integer> findAnagrams(String s, String p) {
        // s和p的长度
        int sLen = s.length(), pLen = p.length();

        // 如果s的长度小于p的长度，直接返回空列表
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        // 存储结果的列表
        List<Integer> ans = new ArrayList<Integer>();
        // s和p中字符的计数数组
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 初始化pCount和sCount数组
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        // 如果初始窗口的字符计数相同，则添加索引0到结果列表
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 遍历s，更新窗口并比较字符计数
        for (int i = 0; i < sLen - pLen; ++i) {
            // 移除窗口左边界的字符计数
            --sCount[s.charAt(i) - 'a'];
            // 添加窗口新右边界的字符计数
            ++sCount[s.charAt(i + pLen) - 'a'];

            // 如果窗口的字符计数与p的字符计数相同，添加当前索引到结果列表
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        // 返回结果列表
        return ans;
    }

    /**
     * 主函数，用于测试
     */
    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        // 测试案例
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));
    }
}
