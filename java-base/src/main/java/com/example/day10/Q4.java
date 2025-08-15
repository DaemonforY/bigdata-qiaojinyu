package com.example.day10;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q4 {
    // 4. 将一个字符串数组中的所有单词合并成一个用逗号分隔的字符串（不重复）
    public static void main(String[] args) {
        Q4 q4 = new Q4();
        // 4. 将一个字符串数组中的所有单词合并成一个用逗号分隔的字符串（不重复）
        System.out.println("\n4. 将字符串数组中的所有单词合并成一个用逗号分隔的字符串（不重复）:");
        String[] wordArray = {"hello", "world", "java", "stream", "hello", "world"};
        q4.exercise4(wordArray);
    }
    public void exercise4(String[] wordArray) {
        String result = Arrays.stream(wordArray)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("原始数组: " + Arrays.toString(wordArray));
        System.out.println("合并结果: " + result);
    }
}
