package com.example.LeetCode.day1;

import java.util.*;

/**
 *字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * */

public class GroupAnagrams {
    /**
     * 将一组字符串按照字母异位词分组返回
     * 字母异位词是指字母相同，但排列不同的字符串
     *
     * @param strs 输入的字符串数组
     * @return 返回一个列表，其中包含分组后的字母异位词列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，键是特征标识，值是具有相同标识的字符串列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历输入的字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组
            char[] chars = str.toCharArray();
            // 对字符数组排序，排序后的字符数组就是字母异位词的特征标识
            Arrays.sort(chars);
            // 将排序后的字符数组转换回字符串作为键
            String key = new String(chars);

            // 如果键不存在，创建一个新的列表
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将当前字符串添加到对应的列表中
            map.get(key).add(str);
        }

        // 将哈希表中的所有值（列表）转换为结果列表并返回
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // 测试案例1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs1));
        // 输出: [[bat], [nat, tan], [ate, eat, tea]]

        // 测试案例2
        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2));
        // 输出: [[""]]

        // 测试案例3
        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3));
        // 输出: [["a"]]
    }
}

