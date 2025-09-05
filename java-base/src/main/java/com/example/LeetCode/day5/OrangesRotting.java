package com.example.LeetCode.day5;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 解决腐烂橘子问题的类
 * 该问题中，1 代表新鲜橘子，2 代表腐烂橘子，0 代表空单元格
 * 每个单位时间，腐烂橘子会将其周围四个方向上的新鲜橘子腐烂
 * 问题的目标是找出所有橘子腐烂的最短时间如果不可能使所有橘子腐烂，则返回 -1
 */
 class OrangesRotting {
    // 方向数组，用于表示四个方向的移动
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    /**
     * 计算所有橘子腐烂的最短时间
     *
     * @param grid 二维数组，表示网格，其中 1 是新鲜橘子，2 是腐烂橘子，0 是空单元格
     * @return 所有橘子腐烂的最短时间，如果不可能使所有橘子腐烂，则返回 -1
     */
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();

        // 将所有腐烂橘子的位置加入队列，并设置其深度为 0
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }

        int ans = 0;
        // 广度优先搜索，将腐烂橘子的腐烂时间扩散到周围的新鲜橘子
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                // 当前位置有新鲜橘子，将其腐烂，并更新队列和深度信息
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        // 检查网格中是否还有新鲜橘子，如果有，则返回 -1
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }

        // 返回所有橘子腐烂的最短时间
        return ans;
    }

    public static void main(String[] args) {
        OrangesRotting s = new OrangesRotting();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        // 输出结果，即所有橘子腐烂的最短时间
        System.out.println(s.orangesRotting(grid));
    }
}
