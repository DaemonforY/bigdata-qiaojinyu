package com.example.LeetCode.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋顺序类，用于将二维矩阵中的元素按螺旋顺序排列
 */
class SpiralOrder{
    /**
     * 将给定的二维矩阵中的元素按螺旋顺序排列
     *
     * @param matrix 二维整数数组，表示待处理的矩阵
     * @return 返回一个列表，包含按螺旋顺序排列的矩阵元素
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // 获取矩阵的行数和列数
        int m = matrix.length, n = matrix[0].length;
        // 初始化四个边界
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        // 当左边界不大于右边界且上边界不大于下边界时，进行循环
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // 从右到左
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }
            bottom--;
            // 从下到上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }

    /**
     * 主函数，用于测试螺旋顺序功能
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        // 测试用例矩阵
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // 输出按螺旋顺序排列的矩阵元素
        System.out.println(s.spiralOrder(matrix));

    }
}
