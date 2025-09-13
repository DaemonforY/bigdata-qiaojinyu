package com.example.LeetCode.day11;

/**
 * 经典的动态规划问题
 * 爬楼梯
 * ClimbStairs 类提供了一个方法，用于计算爬到楼梯顶部的不同方式的数量。
 * 爬楼梯的规则是每次只能爬1步或2步。
 */
public class ClimbStairs {
    /**
     * 计算爬到有 n 个台阶的楼梯顶部的不同方式的数量。
     *
     * @param n 楼梯的总台阶数。
     * @return 爬到顶部的不同方式的数量。
     */
    public int climbStairs(int n) {
        // 处理基本情况
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 初始化前两个状态
        int prevPrev = 1; // 对应 n-2 的情况
        int prev = 2;     // 对应 n-1 的情况
        int current = 0;  // 用于计算当前 n 的情况

        // 从3开始计算到n
        for (int i = 3; i <= n; i++) {
            // 当前台阶的方式数量等于前两个台阶方式数量之和
            current = prevPrev + prev;
            // 更新前两个状态的值
            prevPrev = prev;
            prev = current;
        }

        // 返回 n 台阶的方式数量
        return current;
    }

    /**
     * 主函数用于测试 climbStairs 方法。
     *
     * @param args 命令行参数，未使用。
     */
    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        // 测试3个台阶的情况
        System.out.println(cs.climbStairs(3));
        // 测试6个台阶的情况
        System.out.println(cs.climbStairs(6));
    }
}


