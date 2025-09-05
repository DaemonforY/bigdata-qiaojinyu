package com.example.LeetCode.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permute {
    /**
     * 解决方案类，用于生成给定数字数组的所有可能排列
     */
    public List<List<Integer>> permute(int[] nums) {
        /**
         * 主函数，返回一个包含所有可能排列的列表
         * @param nums 输入的数字数组
         * @return 包含所有可能排列的列表
         */
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        /**
         * 回溯函数，用于生成所有可能的排列
         * @param n 数组的长度
         * @param output 当前排列
         * @param res 存储所有排列的列表
         * @param first 当前处理的位置
         */
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
    }
}


