package com.example.LeetCode.day9;

import java.util.Arrays;

/**
 * 解决每日温度问题的类
 */
public class DailyTemperatures {

    /**
     * 计算每一天后的下一个更高温度出现在几天后
     *
     * @param temperatures 表示每天的温度的整数数组
     * @return 一个整数数组，其中每个元素表示对于每一天，下一个更高温度出现在几天后
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // 数组长度
        int length = temperatures.length;
        // 存放结果的数组
        int[] ans = new int[length];
        // 存放每一个温度最早出现的下标，初始化为最大值
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);

        // 从后向前遍历温度数组
        for (int i = length - 1; i >= 0; --i) {
            // 初始化下一个更高温度的下标为最大值
            int warmerIndex = Integer.MAX_VALUE;
            // 查找当前温度之后的所有更高温度的最早下标
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            // 如果找到了下一个更高温度的下标，则计算与当前的差值
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            // 更新当前温度的最早下标
            next[temperatures[i]] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        // 测试用例
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures.dailyTemperatures(temperatures);
        // 打印结果
        System.out.println(Arrays.toString(ans));
    }
}


