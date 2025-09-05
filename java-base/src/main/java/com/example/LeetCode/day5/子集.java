package com.example.LeetCode.day5;

import java.util.ArrayList;
import java.util.List;
// 子集类，用于生成给定数组的所有可能子集
class Subsets {
    // 用于存储单个子集的列表
    List<Integer> t = new ArrayList<Integer>();
    // 用于存储所有子集的列表
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 生成给定数组的所有子集
     * 使用位运算来遍历所有可能的子集组合
     *
     * @param nums 输入的整数数组
     * @return 包含所有可能子集的列表
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 关键修复：每次调用时先清空结果列表
        ans.clear();
        // 数组长度
        int n = nums.length;
        // 遍历所有可能的子集组合，使用位运算
        for (int mask = 0; mask < (1 << n); ++mask) {
            // 清空当前子集，准备生成新的子集
            t.clear();
            // 检查每个元素是否应该包含在当前子集中
            for (int i = 0; i < n; ++i) {
                // 如果当前位为1，则将对应元素添加到子集中
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            // 将生成的子集添加到结果列表中
            ans.add(new ArrayList<Integer>(t));
        }
        // 返回所有子集的列表
        return ans;
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
        System.out.println(s.subsets(new int[]{0}));


    }
}
