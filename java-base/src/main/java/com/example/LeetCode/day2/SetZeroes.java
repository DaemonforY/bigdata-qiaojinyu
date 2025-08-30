package com.example.LeetCode.day2;

/**
 * 解决矩阵中元素为0时，将其所在行和列的所有元素都设为0的问题
 */
class SetZeroes {
    /**
     * 将矩阵中元素为0的行和列的所有元素都设为0
     *
     * @param matrix 二维整数数组，代表待处理的矩阵
     */
    public void setZeroes(int[][] matrix) {
        // 获取矩阵的行数和列数
        int m = matrix.length, n = matrix[0].length;
        // 创建行标记数组，用于记录哪些行需要置零
        boolean[] row = new boolean[m];
        // 创建列标记数组，用于记录哪些列需要置零
        boolean[] col = new boolean[n];

        // 第一次遍历矩阵，记录需要置零的行和列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当发现元素为0时，标记对应的行和列为true
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        // 第二次遍历矩阵，根据标记数组将相应位置的元素置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前元素所在的行或列被标记过，则将该元素置为0
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 主函数，用于测试矩阵置零功能
     */
    public static void main(String[] args) {
        // 创建SetZeroes类的实例
        SetZeroes service = new SetZeroes();
        // 定义测试用的矩阵
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        // 调用setZeroes方法处理矩阵
        service.setZeroes(matrix);

        // 遍历并打印处理后的矩阵
        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
