package com.example.LeetCode.day5;


import java.util.ArrayList;
import java.util.List;


/**
 * 生成所有可能的n对括号的组合
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
class GenerateParenthesis {
    /**
     * 主入口函数，生成n对括号的所有组合
     *
     * @param n 括号对数
     * @return 所有可能的括号组合列表
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    /**
     * 递归生成所有可能的括号组合
     *
     * @param current 当前正在构建的括号数组
     * @param pos     当前构建的位置
     * @param result  存储所有有效组合的结果列表
     */
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 检查括号数组是否有效
     *
     * @param current 待检查的括号数组
     * @return 如果括号数组有效则返回true，否则返回false
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * 主函数，用于测试括号生成
     */
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
