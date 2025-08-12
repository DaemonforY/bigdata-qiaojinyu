package com.example.day10;

import java.util.Arrays;
import java.util.List;

//筛选字符串长度大于3的单词，并转为大写后去重，按字母顺序输出
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "lambda", "hello");
        q1.exercises(words);
    }
    public void exercises(List<String> words){
        List<String> result = words.stream()
                .filter(word -> word.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList();
        System.out.println("原始列表："+ words);
        System.out.println("结果：" + result);
    }

}
