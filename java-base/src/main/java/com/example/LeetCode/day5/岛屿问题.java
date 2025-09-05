package com.example.LeetCode.day5;

/**
 * Solution类用于解决统计岛屿数量的问题
 */
class Solution {
    /**
     * 使用深度优先搜索(DFS)标记与当前陆地相连的所有陆地
     *
     * @param grid 二维字符数组，表示地图
     * @param r    当前位置的行坐标
     * @param c    当前位置的列坐标
     */
    void dfs(char[][] grid, int r, int c) {
        // 获取地图的行数和列数
        int nr = grid.length;
        int nc = grid[0].length;

        // 检查当前位置是否越界或已经是海水
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // 将当前位置标记为海水，避免重复计数
        grid[r][c] = '0';
        // 递归地标记当前位置上下左右相邻的陆地
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 计算给定地图中岛屿的数量
     *
     * @param grid 二维字符数组，表示地图
     * @return 返回岛屿的数量
     */
    public int numIslands(char[][] grid) {
        // 检查地图是否为空
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 获取地图的行数和列数
        int nr = grid.length;
        int nc = grid[0].length;
        // 初始化岛屿数量为0
        int num_islands = 0;
        // 遍历地图上的每个位置
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                // 如果当前位置是未标记的陆地
                if (grid[r][c] == '1') {
                    // 岛屿数量加1
                    ++num_islands;
                    // 使用DFS标记与当前陆地相连的所有陆地
                    dfs(grid, r, c);
                }
            }
        }

        // 返回岛屿的数量
        return num_islands;
    }

    /**
     * 主函数，用于测试计算岛屿数量的功能
     */
    public static void main(String[] args) {
        // 定义两个测试用的地图
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char [][] grid1 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        // 创建Solution对象并计算岛屿数量
        System.out.println(new Solution().numIslands(grid));
        System.out.println(new Solution().numIslands(grid1));
    }
}


