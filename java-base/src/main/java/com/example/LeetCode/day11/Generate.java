package com.example.LeetCode.day11;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        /**
         * 生成杨辉三角的前numRows行
         * 杨辉三角是一个经典的数学问题，每一行的数字都是上一行相邻两数之和
         * 此方法用于生成一个包含杨辉三角前numRows行的列表
         *
         * @param numRows 指定生成杨辉三角的行数
         * @return 返回一个包含杨辉三角前numRows行的列表
         */
        // 创建结果列表
        List<List<Integer>> result = new ArrayList<>();

        // 处理特殊情况
        if (numRows <= 0) {
            return result;
        }

        // 第一行总是[1]
        result.add(new ArrayList<>());
        result.get(0).add(1);

        // 生成从第二行到第numRows行
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            // 每行的第一个元素都是1
            currRow.add(1);

            // 填充中间元素，每个元素等于上一行左右两个元素之和
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // 每行的最后一个元素都是1
            currRow.add(1);

            result.add(currRow);
        }

        return result;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(5));
        System.out.println(generate.generate(1));
    }
}
