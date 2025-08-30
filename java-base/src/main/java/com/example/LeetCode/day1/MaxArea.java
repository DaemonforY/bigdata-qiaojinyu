package com.example.LeetCode.day1;

/**
 * MaxArea 类用于解决从给定的高度数组中找出两个点，
 * 使得它们与 x 轴一起形成的容器能够盛放最多的水。
 */
public class MaxArea {
    /**
     * 盛最多水的容器
     * 计算给定高度数组中两个点之间可以形成的最大面积。
     *
     * @param height 高度数组，每个元素代表一个点的高度
     * @return 返回可以形成的最大面积
     */
    public int maxArea(int[] height) {
        // 初始化左右指针
        int l = 0, r = height.length - 1;
        // 初始化最大面积为 0
        int ans = 0;
        // 当左指针小于右指针时循环
        while (l < r) {
            // 计算当前面积，取左右指针中较小的高度乘以它们之间的距离
            int area = Math.min(height[l], height[r]) * (r - l);
            // 更新最大面积
            ans = Math.max(ans, area);
            // 将指向较短高度的指针向内移动
            if (height[l] <= height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        // 返回最大面积
        return ans;
    }

    /**
     * 主函数用于测试 maxArea 方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 测试用例数据
        int[] height = {1,8,6,2,5,4,8,3,7};
        // 创建 MaxArea 实例
        MaxArea maxArea = new MaxArea();
        // 调用 maxArea 方法并打印结果
        System.out.println(maxArea.maxArea(height));
    }
}

