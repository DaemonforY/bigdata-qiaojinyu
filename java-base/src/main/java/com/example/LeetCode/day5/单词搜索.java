package com.example.LeetCode.day5;

class WordSearch {
    // 定义四个方向，用于深度优先搜索：左、右、上、下
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 在二维字符网格中搜索单词
     * @param board 二维字符网格
     * @param word 待搜索的单词
     * @return 如果能找到单词返回true，否则返回false
     */
    public boolean exist(char[][] board, String word) {
        // 将单词转换为字符数组，便于逐个字符匹配
        char[] w = word.toCharArray();
        // 遍历二维字符网格的每一个位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 如果当前位置的字符与单词的第一个字符匹配，则开始深度优先搜索
                if (dfs(i, j, 0, board, w)) {
                    return true; // 搜到了！
                }
            }
        }
        return false; // 没搜到
    }

    /**
     * 深度优先搜索函数
     * @param i 当前位置的行索引
     * @param j 当前位置的列索引
     * @param k 当前待匹配的字符索引
     * @param board 二维字符网格
     * @param word 待匹配的字符数组
     * @return 如果能匹配到单词返回true，否则返回false
     */
    private boolean dfs(int i, int j, int k, char[][] board, char[] word) {
        // 如果当前位置的字符与待匹配的字符不相同，返回false
        if (board[i][j] != word[k]) {
            return false;
        }
        // 如果已经匹配到最后一个字符，返回true
        if (k == word.length - 1) {
            return true;
        }
        // 标记当前位置的字符为已访问
        board[i][j] = 0;
        // 遍历四个方向
        for (int[] d : DIRS) {
            int x = i + d[0];
            int y = j + d[1]; // 相邻格子
            // 如果相邻格子在网格范围内且深度优先搜索成功，则返回true
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                return true;
            }
        }
        // 恢复当前位置的字符
        board[i][j] = word[k];
        return false; // 没搜到
    }

    public static void main(String[] args) {
        // 定义二维字符网格和待搜索的单词
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        // 创建WordSearch对象并调用exist方法搜索单词
        System.out.println(new WordSearch().exist(board, word));
    }
}
