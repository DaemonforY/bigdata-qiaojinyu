package com.example.LeetCode.day3;

/**
 * 旋转矩阵类
 * 提供方法将给定的二维矩阵顺时针旋转90度
 */
public class Rotate {
    /**
     * 顺时针旋转二维矩阵90度
     *
     * @param matrix 二维整数数组，表示需要旋转的矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 步骤1：矩阵转置（行变列互换）
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 交换元素[i][j]和[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 步骤2：反转每一行
        for (int i = 0; i < n; i++) {
            // 反转第i行的元素
            int left = 0;
            int right = n - 1;
            while (left < right) {
                // 交换元素[i][left]和[i][right]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Rotate solution = new Rotate();

        // 测试案例
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("旋转前：");
        printMatrix(matrix);

        solution.rotate(matrix);

        System.out.println("旋转后：");
        printMatrix(matrix);
        // 输出:
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }

    // 辅助方法：打印矩阵
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
