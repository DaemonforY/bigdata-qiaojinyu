package com.example.LeetCode.day9;
//买卖股票的最佳时机
/**
 * 该类提供了一个方法来计算给定股票价格数组情况下的最大利润
 */
public class MaxProfit{
    /**
     * 计算给定股票价格数组的最大利润
     *
     * @param prices 股票每天的价格数组
     * @return 返回从股票交易中获得的最大利润
     */
    public int maxProfit(int prices[]) {
        // 初始化最小价格为最大整数值，用于后续比较
        int minprice = Integer.MAX_VALUE;
        // 初始化最大利润为0
        int maxprofit = 0;
        // 遍历价格数组
        for (int i = 0; i < prices.length; i++) {
            // 如果当前价格小于已知的最小价格，则更新最小价格
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                // 如果当前价格与最小价格的差大于已知的最大利润，则更新最大利润
                maxprofit = prices[i] - minprice;
            }
        }
        // 返回最大利润
        return maxprofit;
    }

    /**
     * 程序入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        // 使用示例数据调用maxProfit方法并打印结果
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
