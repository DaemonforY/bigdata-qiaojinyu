package com.example.LeetCode.day5;

import java.util.ArrayList;
import java.util.List;

/***
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 */
class CombinationSum {
    /**
     * 主函数，用于找到所有数字和为 target 的组合。
     *
     * @param candidates 无重复元素的数组
     * @param target 目标和
     * @return 所有符合条件的组合列表
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    /**
     * 深度优先搜索函数，用于递归寻找所有符合条件的组合。
     *
     * @param candidates 无重复元素的数组
     * @param target 当前目标和
     * @param ans 存储所有符合条件的组合的列表
     * @param combine 当前的组合列表
     * @param idx 当前在 candidates 中的位置
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        // 边界条件：如果当前位置已经超出数组长度，则直接返回
        if (idx == candidates.length) {
            return;
        }
        // 如果当前目标和为0，说明找到了一组符合条件的组合，将其添加到结果列表中
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 递归调用，直接跳过当前位置的数，探索下一个数
        dfs(candidates, target, ans, combine, idx + 1);
        // 如果当前目标和大于等于当前位置的数，说明可以选择当前位置的数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            // 递归调用，选择当前位置的数后，探索下一个数
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            // 回溯，移除最后添加的数，探索其他可能的组合
            combine.remove(combine.size() - 1);
        }
    }
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = solution.combinationSum(candidates, target);
        System.out.println(ans);
    }
}

