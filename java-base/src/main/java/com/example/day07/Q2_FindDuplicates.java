package com.example.day07;

import java.util.*;

public class Q2_FindDuplicates {
    public static void main(String[] args) {
        System.out.println("=== 题目2：查找数组中的重复元素 ===\n");
        System.out.println("题目2：查找数组中的重复元素");
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("原数组: " + Arrays.toString(arr));
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println("重复元素: " + duplicates);
        System.out.println();
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}
