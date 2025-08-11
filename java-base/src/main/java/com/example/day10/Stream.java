package com.example.day10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        //筛选和收集
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(evens);

        //筛选和收集
        List<String> words = Arrays.asList("java", "stream", "lambda");
        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperWords);

       //去重
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> unique = nums.stream()
                    .distinct()
                    .toList();
        System.out.println(unique);

        // 分组操作：根据单词的首字母将单词列表分组
        List<String> words1 = Arrays.asList("apple", "banana", "apricot", "blueberry");
        // 使用Stream API进行分组
        Map<Object, List<String>> group = words1.stream()
        // 使用Collectors.groupingBy函数式接口进行分组
         // 分组依据是单词的首字母
         .collect(Collectors.groupingBy(w -> w.charAt(0)));
        // 输出分组结果
        System.out.println(group);

        //统计与归约
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers1.stream().mapToInt(Integer::intValue).sum();
        int max = numbers1.stream().mapToInt(Integer::intValue).max().orElse(0);
        double avg = numbers1.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("最大值：" + max);
        System.out.println("平均值：" + avg);
        System.out.println("和：" + sum);



    }
}
