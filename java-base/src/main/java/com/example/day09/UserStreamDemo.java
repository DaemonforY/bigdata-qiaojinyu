package com.example.day09;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
/**
 * @version 1.0
 * @Description: 案例 1：传统循环痛点 → Stream 基础
 *              **问题**：从2000个用户中找出北京地区的前10名VIP用户
 *              **知识点**：
 *              - 链式调用 vs 嵌套判断
 *              - 声明式编程 vs 命令式编程
 *              - 排序与限制的流式组合
 * @Author yongbin
 * @Date 2025/6/26 23:27:08
 */
public class UserStreamDemo {

    @Getter
    static class User {
        private final String name;
        private final String city;
        private final boolean vip;
        private final int score;

        public User(String name, String city, boolean vip, int score) {
            this.name = name;
            this.city = city;
            this.vip = vip;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("User{name='%s', city='%s', vip=%s, score=%d}", name, city, vip, score);
        }
    }

    public static void main(String[] args) {
        // 1. 生成2000个伪用户
        List<String> cityList = Arrays.asList("Beijing", "Shanghai", "Guangzhou", "Shenzhen", "Chengdu");
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 2000; i++) {
            String name = "User" + i;
            String city = cityList.get(random.nextInt(cityList.size()));
            boolean vip = random.nextDouble() < 0.2; // 20%概率为VIP
            int score = 50 + random.nextInt(51);     // 50~100分
            users.add(new User(name, city, vip, score));
        }




        // 传统解法（嵌套循环 + 临时集合）
        List<User> top10BeijingVip1 = new ArrayList<>();
        for (User user : users) {
            if ("Beijing".equals(user.getCity()) && user.isVip()) {
                top10BeijingVip1.add(user);
                if (top10BeijingVip1.size() >= 10) {
                    break;
                }
            }
        }

        // 2. Stream筛选北京的VIP用户，按分数降序取前10
        List<User> top10BeijingVip = users.stream()
                .filter(u -> "Beijing".equals(u.getCity()))
                .filter(User::isVip)
                .sorted(Comparator.comparing(User::getScore).reversed())
                .limit(10)
                .collect(Collectors.toList());

        // 3. 打印结果
        System.out.println("北京地区前10名VIP用户：");
        top10BeijingVip.forEach(System.out::println);
    }
}