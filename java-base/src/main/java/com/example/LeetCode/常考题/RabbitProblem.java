package com.example.LeetCode.常考题;

/**
 * 解决兔子繁殖问题的类
 * 该问题假设每对成年兔子每月可以生一对小兔子，且小兔子需要一个月时间成熟
 * 本类提供了两种解决方案：递归和迭代
 */
class RabbitProblem {

    /**
     * 使用递归方法计算第n个月的兔子数量
     *
     * @param n 第n个月
     * @return 第n个月的兔子数量
     */
    public static long rabbitRecursive(int n) {
        // 边界条件：如果n小于等于0，返回0；如果n等于1或2，返回1
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 递归关系：第n个月的兔子数 = 第n-1个月的兔子数 + 第n-2个月的兔子数
        return rabbitRecursive(n - 1) + rabbitRecursive(n - 2);
    }



    /**
     * 主函数，用于测试兔子问题的解决方案
     */
    public static void main(String[] args) {
        int months = 12; // 计算12个月后的兔子数量

        // 输出递归和非递归方法在12个月后的兔子数量
        System.out.println("递归实现：第" + months + "个月有" + rabbitRecursive(months) + "对兔子");

        }
    }


